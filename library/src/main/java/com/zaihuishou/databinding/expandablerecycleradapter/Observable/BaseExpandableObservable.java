package com.zaihuishou.databinding.expandablerecycleradapter.Observable;

import android.databinding.BaseObservable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;

import java.util.List;

/**
 * 创建者: zhiqiang(谭志强)
 * 创建时间 16-8-3.
 * 作者邮箱 tanzhiqiang@todayoffice.cn
 * 描述:
 */

public abstract class BaseExpandableObservable extends BaseObservable {
    /**
     * item contain child list
     */
    public ObservableArrayList<Object> mChildList;
    /**
     * item is expanded
     */
    public ObservableBoolean isExpand;

    private ItemListExpandCollapseListener mItemListExpandCollapseListener;

    public BaseExpandableObservable() {
        mChildList = new ObservableArrayList<>();
        isExpand = new ObservableBoolean(false);
    }

    public List<Object> getChildList() {
        return mChildList.subList(0, mChildList.size());
    }

    public void setChildList(List<Object> childList) {
        mChildList.addAll(childList);
    }

    public boolean getIsExpand() {
        return isExpand.get();
    }

    public void setIsExpand(boolean expand) {
        this.isExpand.set(expand);
    }

    public ItemListExpandCollapseListener getItemListExpandCollapseListener() {
        return mItemListExpandCollapseListener;
    }

    public void setItemListExpandCollapseListener(ItemListExpandCollapseListener itemListExpandCollapseListener) {
        mItemListExpandCollapseListener = itemListExpandCollapseListener;
    }

    /**
     * implementations to be notified of expand/collapse state change events.
     */
    public interface ItemListExpandCollapseListener {

        /**
         * Called when a list item is expanded.
         *
         * @param position The index of the item in the list being expanded
         */
        void onItemListExpanded(int position);

        /**
         * Called when a list item is collapsed.
         *
         * @param position The index of the item in the list being collapsed
         */
        void onItemListCollapsed(int position);

    }
}
