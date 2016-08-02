package com.zaihuishou.databinding.expandablerecycleradapter.viewholder;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * * creater: zaihuishou
 * create time: 16-8-2
 * author email:tanzhiqiang.cathy@gmail.com
 * desc:
 */

public class BindingViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {

    private T mBinding;

    public BindingViewHolder(T binding) {
        super(binding.getRoot());
        this.mBinding = binding;
    }

    public T getBinding() {
        return mBinding;
    }
}
