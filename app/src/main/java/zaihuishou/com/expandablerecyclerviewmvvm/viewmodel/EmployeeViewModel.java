package zaihuishou.com.expandablerecyclerviewmvvm.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.view.View;
import android.widget.Toast;

/**
 * * creater: zaihuishou
 * create time: 16-8-2
 * author email:tanzhiqiang.cathy@gmail.com
 * desc:
 */

public class EmployeeViewModel extends BaseObservable {

    public ObservableField<String> name;

    private Context mContext;

    public EmployeeViewModel() {
        this.name = new ObservableField<>();
    }

    public EmployeeViewModel(Context pContext, String s) {
        this.name = new ObservableField<>(s);
        this.mContext = pContext;
    }

    public void setName(String s) {
        this.name.set(s);
    }

    public void onItemClicked(View view) {
        Toast.makeText(mContext, "onItemClicked：" + name.get(), Toast.LENGTH_SHORT).show();
    }
}
