package com.zaihuishou.databinding.expandablerecycleradapter.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.zaihuishou.databinding.expandablerecycleradapter.util.AdapterItemUtil;
import com.zaihuishou.databinding.expandablerecycleradapter.viewholder.AbstractExpandableAdapterItem;
import com.zaihuishou.databinding.expandablerecycleradapter.viewholder.BindingViewHolder;

import java.util.List;

/**
 * 创建者: zhiqiang(谭志强)
 * 创建时间 16-8-2.
 * 作者邮箱 tanzhiqiang@todayoffice.cn
 * 描述:
 */

public abstract class BaseExpandableAdapter2 extends RecyclerView.Adapter<BindingViewHolder>
        implements AbstractExpandableAdapterItem.ParentListItemExpandCollapseListener {

    protected List<Object> mDataList;

    private int mItemType;

    private AdapterItemUtil mUtil = new AdapterItemUtil();

    private BaseExpandableAdapter2.ExpandCollapseListener mExpandCollapseListener;

    private LayoutInflater mLayoutInflater;

    public BaseExpandableAdapter2(Context context, List<Object> dataList) {
        mDataList = dataList;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getItemViewType(int position) {
        mItemType = getItemViewType(mDataList.get(position));
        return mUtil.getIntType(mItemType);
    }

    public int getItemViewType(Object t) {
        return -1;
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
        onBindItemViewHolder(holder,mDataList.get(position), position);
    }

    public abstract void onBindItemViewHolder(BindingViewHolder holder, Object o, int index);

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

    @Override
    public void onParentListItemExpanded(int position) {

    }

    @Override
    public void onParentListItemCollapsed(int position) {

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
