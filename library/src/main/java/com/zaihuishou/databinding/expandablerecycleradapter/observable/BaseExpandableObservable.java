package com.zaihuishou.databinding.expandablerecycleradapter.observable;

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

    protected ItemListExpandCollapseListener mItemListExpandCollapseListener;

    public BaseExpandableObservable() {
        mChildList = new ObservableArrayList<>();
        isExpand = new ObservableBoolean(false);
    }

    public abstract ObservableArrayList<Object> getChildList();

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
         * @param baseExpandableObservable The item in the list being expanded
         */
        void onItemListExpanded(BaseExpandableObservable baseExpandableObservable);

        /**
         * Called when a list item is collapsed.
         *
         * @param baseExpandableObservable The item in the list being collapsed
         */
        void onItemListCollapsed(BaseExpandableObservable baseExpandableObservable);

    }

    /**
     * Callback triggered when expansion state is changed, but not during
     * initialization.
     * <p>
     * Useful for implementing animations on expansion.
     *
     * @param expanded true if view is expanded before expansion is toggled,
     *                 false if not
     */
    public abstract void onExpansionToggled(boolean expanded);
}
