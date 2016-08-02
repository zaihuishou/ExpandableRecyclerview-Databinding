package zaihuishou.com.expandablerecyclerviewmvvm.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

/**
 * 创建者: zhiqiang(谭志强)
 * 创建时间 16-8-2.
 * 作者邮箱 tanzhiqiang@todayoffice.cn
 * 描述:
 */

public class Department extends BaseObservable {

    public ObservableField<String> name;

    public Department() {
        this.name = new ObservableField<>();
    }

    public void setName(String newName) {
        this.name.set(newName);
    }
}
