package zaihuishou.com.expandablerecyclerviewmvvm.viewmodel;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.widget.Toast;

import com.zaihuishou.databinding.expandablerecycleradapter.observable.BaseExpandableObservable;

/**
 * 创建者: zhiqiang(谭志强)
 * 创建时间 16-8-2.
 * 作者邮箱 tanzhiqiang@todayoffice.cn
 * 描述:
 */

public class CompanyVm extends BaseExpandableObservable {

    public ObservableField<String> text;
    private Context mContext;

    public CompanyVm(Context context) {
        super();
        this.mContext = context;
        text = new ObservableField<>("看到就按看放大镜阿飞卡我家");
    }

    @Override
    public ObservableArrayList<Object> getChildList() {
        return mChildList;
    }

    @Override
    public void onExpansionToggled(boolean expanded) {
        Toast.makeText(mContext, "onExpansionToggled：" + expanded, Toast.LENGTH_SHORT).show();
    }

    public void setText(String s) {
        if (!this.text.get().equals(s)) {
            this.text.set(s);
        }
    }

    public void onTextClick() {
        if (mItemListExpandCollapseListener != null) {
            if (isExpand.get())
                mItemListExpandCollapseListener.onItemListCollapsed(this);
            else mItemListExpandCollapseListener.onItemListExpanded(this);
        }
    }
}
