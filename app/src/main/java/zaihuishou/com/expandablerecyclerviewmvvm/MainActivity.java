package zaihuishou.com.expandablerecyclerviewmvvm;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.zaihuishou.databinding.expandablerecycleradapter.adapter.BaseExpandableAdapter;

import java.util.ArrayList;
import java.util.List;

import zaihuishou.com.expandablerecyclerviewmvvm.databinding.ActivityMainBinding;
import zaihuishou.com.expandablerecyclerviewmvvm.viewmodel.CompanyVm;
import zaihuishou.com.expandablerecyclerviewmvvm.viewmodel.Department;
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
    private List<Object> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mMainViewModel = new MainViewModel();
        mainBinding.setVm(mMainViewModel);
        setSupportActionBar(mainBinding.toolbar);
        mainBinding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        initRecyclerView();
    }

    private void initRecyclerView() {
        mList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                CompanyVm companyVm = new CompanyVm();
                companyVm.setText("公司:" + i + "肯定房价啊矿大积分发");
                mList.add(companyVm);
            } else {
                Department department = new Department();
                department.setName("部门" + i + "231141445");
                mList.add(department);
            }
        }
        mAdapter = new BaseExpandableAdapter(this, mList) {
            @NonNull
            @Override
            public int getItemView(int type) {
                switch (type) {
                    case 1:
                        return R.layout.item_company;
                    case 2:
                        return R.layout.item_department;
                }
                return -1;
            }

            @Override
            public int getItemViewType(Object t) {
                if (t instanceof CompanyVm)
                    return 1;
                if (t instanceof Department)
                    return 2;
                return super.getItemViewType(t);
            }

            @Override
            public int getVariable(Object o, int index) {
                if (o instanceof CompanyVm)
                    return zaihuishou.com.expandablerecyclerviewmvvm.BR.companyvm;
                else if (o instanceof Department)
                    return zaihuishou.com.expandablerecyclerviewmvvm.BR.vm;
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

}
