package zaihuishou.com.expandablerecyclerviewmvvm.viewmodel;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.databinding.ObservableField;
import android.view.View;

import com.zaihuishou.databinding.expandablerecycleradapter.observable.BaseExpandableObservable;
import com.zaihuishou.databinding.expandablerecycleradapter.viewholder.BindingViewHolder;

import zaihuishou.com.expandablerecyclerviewmvvm.databinding.ItemCompanyBinding;

/**
 * * creater: zaihuishou
 * create time: 16-8-2
 * author email:tanzhiqiang.cathy@gmail.com
 * desc:
 */
public class CompanyViewModel extends BaseExpandableObservable {

    public ObservableField<String> text;
    private Context mContext;

    public CompanyViewModel(Context context) {
        this.mContext = context;
        text = new ObservableField<>();
    }

    @Override
    public void onExpansionToggled(BindingViewHolder bindingViewHolder, int index, boolean expanded) {
        ItemCompanyBinding binding = (ItemCompanyBinding) bindingViewHolder.getBinding();
        rotationArrow(binding, expanded);
    }

    /**
     * play arrow animation
     *
     * @param binding
     * @param expanded
     */
    private void rotationArrow(ItemCompanyBinding binding, boolean expanded) {
        float start, target;
        if (expanded) {
            start = 0f;
            target = 90f;
        } else {
            start = 90f;
            target = 0f;
        }
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(binding.arrow, View.ROTATION, start, target);
        objectAnimator.setDuration(300);
        objectAnimator.start();
    }

    public void setText(String s) {
        this.text.set(s);
    }

    public void onCompanyClick() {
        if (mItemListExpandCollapseListener != null) {
            if (isExpand.get())
                mItemListExpandCollapseListener.onItemListCollapsed(this);
            else mItemListExpandCollapseListener.onItemListExpanded(this);
        }
    }
}
