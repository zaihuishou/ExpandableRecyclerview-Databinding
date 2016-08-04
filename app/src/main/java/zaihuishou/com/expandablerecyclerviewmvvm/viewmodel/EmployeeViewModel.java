package zaihuishou.com.expandablerecyclerviewmvvm.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

/**
 * 创建者: zhiqiang(谭志强)
 * 创建时间 16-8-4.
 * 作者邮箱 tanzhiqiang@todayoffice.cn
 * 描述:
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
