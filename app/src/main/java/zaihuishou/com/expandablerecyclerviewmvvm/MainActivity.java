package zaihuishou.com.expandablerecyclerviewmvvm;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.zaihuishou.databinding.expandablerecycleradapter.adapter.BaseExpandableAdapter;

import java.util.ArrayList;
import java.util.List;

import zaihuishou.com.expandablerecyclerviewmvvm.databinding.ActivityMainBinding;
import zaihuishou.com.expandablerecyclerviewmvvm.viewmodel.CompanyViewModel;
import zaihuishou.com.expandablerecyclerviewmvvm.viewmodel.DepartmentViewModel;
import zaihuishou.com.expandablerecyclerviewmvvm.viewmodel.EmployeeViewModel;
import zaihuishou.com.expandablerecyclerviewmvvm.viewmodel.MainViewModel;

/**
 * * creater: zaihuishou
 * create time: 16-8-2
 * author email:tanzhiqiang.cathy@gmail.com
 * desc:
 */
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;
    private MainViewModel mMainViewModel;
    private BaseExpandableAdapter mAdapter;
    private List<Object> mDataList;

    private final static int COMPANY = 1;
    private final static int DEPARTMENT = 2;
    private final static int EMPLOYEE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mMainViewModel = new MainViewModel();
        mainBinding.setVm(mMainViewModel);
        setSupportActionBar(mainBinding.toolbar);
        initRecyclerView();
    }

    public void onFabClick(View view) {

    }

    public void add(View view) {
        /**
         * add an item
         */
        CompanyViewModel addCompanyViewModel = new CompanyViewModel(this);
        addCompanyViewModel.setText("Add Company");
        mAdapter.addItem(mAdapter.getDataList().size(), addCompanyViewModel);
    }

    public void delete(View view) {
        int size = mAdapter.getDataList().size();
        mAdapter.deleteItem(size - 1);
    }

    public void update(View view) {
        Object o = mAdapter.getDataList().get(0);
        if (o instanceof CompanyViewModel) {
            CompanyViewModel companyViewModel = (CompanyViewModel) o;
            companyViewModel.setText("Update Company:" + System.currentTimeMillis() / 1000);
            mAdapter.updateItem(0, companyViewModel);
        }

    }

    public void collapseAll(View view) {
        /**
         * collapse all item
         */
        mAdapter.collapseAllParents();
    }

    private void initRecyclerView() {
        mDataList = new ArrayList<>();
        createCompany();

        mAdapter = new BaseExpandableAdapter(this, mDataList) {
            @NonNull
            @Override
            public int getItemLayout(int type) {
                switch (type) {
                    case COMPANY:
                        return R.layout.item_company;
                    case DEPARTMENT:
                        return R.layout.item_department;
                    case EMPLOYEE:
                        return R.layout.item_employee;
                }
                return -1;
            }

            @Override
            public int getItemViewType(Object t) {
                if (t instanceof CompanyViewModel)
                    return COMPANY;
                if (t instanceof DepartmentViewModel)
                    return DEPARTMENT;
                if (t instanceof EmployeeViewModel)
                    return EMPLOYEE;
                return super.getItemViewType(t);
            }

            @Override
            public int getVariable(Object o, int index) {
                if (o instanceof CompanyViewModel)
                    return zaihuishou.com.expandablerecyclerviewmvvm.BR.companyvm;
                else if (o instanceof DepartmentViewModel)
                    return zaihuishou.com.expandablerecyclerviewmvvm.BR.vm;
                else if (o instanceof EmployeeViewModel)
                    return BR.employeevm;
                return -1;
            }

        };
        mainBinding.listData.setAdapter(mAdapter);
        mainBinding.listData.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        Drawable drawable;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            drawable = getResources().getDrawable(R.drawable.line_bg, null);
        } else {
            drawable = getResources().getDrawable(R.drawable.line_bg);
        }
        mainBinding.listData.addItemDecoration(new DividerItemDecoration(drawable, getResources().getDimensionPixelSize(R.dimen.divider),
                0, getResources().getDimensionPixelSize(R.dimen.divider)));
    }

    private void createCompany() {
        for (int i = 0; i < 2; i++) {
            CompanyViewModel companyVm = new CompanyViewModel(this);
            companyVm.setText(i == 0 ? "Google" : "Apple");
            createDepartment(companyVm);
            mDataList.add(companyVm);
        }
    }

    private void createDepartment(CompanyViewModel companyVm) {
        for (int i = 0; i < 3; i++) {
            DepartmentViewModel departmentViewModel = new DepartmentViewModel("Department：" + i);
            if (i == 0) {
                for (int j = 0; j < 3; j++) {
                    departmentViewModel.getChildList().add(new EmployeeViewModel("Employee：" + j));
                }
            }
            companyVm.mChildList.add(departmentViewModel);
        }
    }
}
