package zaihuishou.com.expandablerecyclerviewmvvm.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

/**
 * * creater: zaihuishou
 * create time: 16-8-2
 * author email:tanzhiqiang.cathy@gmail.com
 * desc:
 */

public class EmployeeViewModel extends BaseObservable {

    public ObservableField<String> name;

    public EmployeeViewModel() {
        this.name = new ObservableField<>();
    }

    public EmployeeViewModel(String s) {
        this.name = new ObservableField<>(s);
    }

    public void setName(String s) {
        this.name.set(s);
    }
}
