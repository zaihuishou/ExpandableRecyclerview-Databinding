package com.zaihuishou.databinding.expandablerecycleradapter.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.zaihuishou.databinding.expandablerecycleradapter.observable.BaseExpandableObservable;
import com.zaihuishou.databinding.expandablerecycleradapter.util.AdapterItemUtil;
import com.zaihuishou.databinding.expandablerecycleradapter.viewholder.BindingViewHolder;

import java.util.List;

/**
 * 创建者: zhiqiang(谭志强)
 * 创建时间 1684.
 * 作者邮箱 tanzhiqiang@todayoffice.cn
 * 描述:
 */

public abstract class BaseExpandableAdapter extends RecyclerView.Adapter<BindingViewHolder> implements BaseExpandableObservable.ItemListExpandCollapseListener {


    /**
     * 创建者: zhiqiang(谭志强)
     * 创建时间 1682.
     * 作者邮箱 tanzhiqiang@todayoffice.cn
     * 描述:
     */
    protected List<Object> mDataList;

    private int mItemType;

    private AdapterItemUtil mUtil = new AdapterItemUtil();

    private BaseExpandableAdapter.ExpandCollapseListener mExpandCollapseListener;

    private LayoutInflater mLayoutInflater;

    public BaseExpandableAdapter(Context context, List<Object> dataList) {
        mDataList = dataList;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public void onItemListCollapsed(int position) {

    }

    @Override
    public void onItemListExpanded(int position) {

    }

    @Override
    public int getItemViewType(int position) {
        mItemType = getItemViewType(mDataList.get(position));
        return mUtil.getIntType(mItemType);
    }

    public int getItemViewType(Object t) {
        return 1;
    }

    @LayoutRes
    @NonNull
    public abstract int getItemView(int type);

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BindingViewHolder(DataBindingUtil.inflate(mLayoutInflater, getItemView(mItemType), parent, false));
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
        Object o = mDataList.get(position);
        ViewDataBinding binding = holder.getBinding();
        binding.setVariable(getVariable(o, position), o);
        binding.executePendingBindings();
    }

    public abstract int getVariable(Object o, int index);

    /**
     * @return data list
     */
    public List<?> getDataList() {
        return mDataList;
    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    public interface ExpandCollapseListener {

        /**
         * Called when a list item is expanded.
         *
         * @param position The index of the item in the list being expanded
         */
        void onListItemExpanded(int position);

        /**
         * Called when a list item is collapsed.
         *
         * @param position The index of the item in the list being collapsed
         */
        void onListItemCollapsed(int position);
    }
}
