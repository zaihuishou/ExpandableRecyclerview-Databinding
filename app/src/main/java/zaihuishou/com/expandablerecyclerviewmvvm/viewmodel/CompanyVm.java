package zaihuishou.com.expandablerecyclerviewmvvm.viewmodel;

import android.databinding.ObservableField;

import com.zaihuishou.databinding.expandablerecycleradapter.observable.BaseExpandableObservable;

/**
 * 创建者: zhiqiang(谭志强)
 * 创建时间 16-8-2.
 * 作者邮箱 tanzhiqiang@todayoffice.cn
 * 描述:
 */

public class CompanyVm extends BaseExpandableObservable {

    public ObservableField<String> text;

    public CompanyVm() {
        text = new ObservableField<>("看到就按看放大镜阿飞卡我家");
    }

    public void setText(String s) {
        if (!this.text.get().equals(s)) {
            this.text.set(s);
        }
    }
}
