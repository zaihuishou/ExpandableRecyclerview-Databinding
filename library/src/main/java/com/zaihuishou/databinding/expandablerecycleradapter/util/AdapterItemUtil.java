package com.zaihuishou.databinding.expandablerecycleradapter.util;

import android.util.SparseArray;

/**
 * creater: zaihuishou
 * create time: 7/13/16.
 * email:tanzhiqiang.cathy@gmail.com
 * collect item type
 */

public class AdapterItemUtil {

    private SparseArray<Object> typeSArr = new SparseArray<>();

    /**
     * @param type item type
     * @return int type of object corresponding
     */
    public int getIntType(Object type) {
        int index = typeSArr.indexOfValue(type);
        if (index == -1) {
            index = typeSArr.size();
            typeSArr.put(index, type);
        }
        return index;
    }

}
