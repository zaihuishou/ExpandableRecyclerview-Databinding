package zaihuishou.com.expandablerecyclerviewmvvm.viewmodel;

import android.animation.ObjectAnimator;
import android.databinding.ObservableField;
import android.view.View;

import com.zaihuishou.databinding.expandablerecycleradapter.observable.BaseExpandableObservable;
import com.zaihuishou.databinding.expandablerecycleradapter.viewholder.BindingViewHolder;

import zaihuishou.com.expandablerecyclerviewmvvm.databinding.ItemDepartmentBinding;

/**
 * 创建者: zhiqiang(谭志强)
 * 创建时间 16-8-2.
 * 作者邮箱 tanzhiqiang@todayoffice.cn
 * 描述:
 */

public class DepartmentViewModel extends BaseExpandableObservable {

    public ObservableField<String> name;

    public DepartmentViewModel(String name) {
        this.name = new ObservableField<>(name);
    }

    public DepartmentViewModel() {
        this.name = new ObservableField<>();
    }

    @Override
    public void onExpansionToggled(BindingViewHolder bindingViewHolder, int index, boolean expanded) {
        ItemDepartmentBinding binding = (ItemDepartmentBinding) bindingViewHolder.getBinding();
        rotationArrow(binding, expanded);
    }

    public void onDepartmentClick() {
        if (mItemListExpandCollapseListener != null) {
            if (isExpand.get())
                mItemListExpandCollapseListener.onItemListCollapsed(this);
            else mItemListExpandCollapseListener.onItemListExpanded(this);
        }
    }

    private void rotationArrow(ItemDepartmentBinding binding, boolean expanded) {
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

    public void setName(String newName) {
        this.name.set(newName);
    }
}
