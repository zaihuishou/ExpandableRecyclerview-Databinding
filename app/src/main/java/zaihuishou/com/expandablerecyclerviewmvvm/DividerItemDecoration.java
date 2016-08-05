package zaihuishou.com.expandablerecyclerviewmvvm;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * * creater: zaihuishou
 * create time: 16-8-2
 * author email:tanzhiqiang.cathy@gmail.com
 * desc:
 */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    protected Drawable dividerDrawable;
    protected int mLeftOrTopPadding;
    protected int mRightOrBottomPadding;

    protected int mHeight;

    public DividerItemDecoration(Drawable divider, int leftOrTopPadding, int rightOrBottomPadding, int height) {
        dividerDrawable = divider;
        this.mLeftOrTopPadding = leftOrTopPadding;
        this.mRightOrBottomPadding = rightOrBottomPadding;
        this.mHeight = height;
    }

    public DividerItemDecoration(Drawable divider, int height) {
        dividerDrawable = divider;
        this.mLeftOrTopPadding = 0;
        this.mRightOrBottomPadding = 0;
        this.mHeight = height;
    }

    public DividerItemDecoration(Drawable divider) {
        dividerDrawable = divider;
        this.mLeftOrTopPadding = 0;
        this.mRightOrBottomPadding = 0;
        this.mHeight = divider.getIntrinsicHeight();
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (dividerDrawable == null) {
            return;
        }
        //if first ,return
        if (parent.getChildLayoutPosition(view) < 1) {
            return;
        }
        int layoutOrientation = getOrientation(parent);
        if (layoutOrientation == LinearLayoutManager.VERTICAL) {
            outRect.top = mHeight;
        } else if (layoutOrientation == LinearLayoutManager.HORIZONTAL) {
            outRect.left = mHeight;
        }
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (dividerDrawable == null) {
            return;
        }
        LinearLayoutManager layoutManager = getLinearLayoutManger(parent);
        if (layoutManager == null) {
            return;
        }
        int firstVisiblePosition = layoutManager.findFirstVisibleItemPosition();
        int orientation = getOrientation(layoutManager);
        int childCount = parent.getChildCount();
        if (orientation == LinearLayoutManager.VERTICAL) {
            int left = parent.getPaddingLeft() + mLeftOrTopPadding;
            int right = parent.getWidth() - parent.getPaddingRight() - mRightOrBottomPadding;
            for (int i = 0; i < childCount; i++) {
                if (i == 0 && firstVisiblePosition == 0) {
                    continue;
                }
                View childView = parent.getChildAt(i);
                RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) childView.getLayoutParams();
                int bottom = childView.getTop() - params.topMargin;
                int top = bottom - mHeight;
                dividerDrawable.setBounds(left, top, right, bottom);
                dividerDrawable.draw(c);
            }
        } else if (orientation == LinearLayoutManager.HORIZONTAL) {
            for (int i = 0; i < childCount; i++) {
                if (i == 0 && firstVisiblePosition == 0) {
                    continue;
                }
                View childView = parent.getChildAt(i);
                RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) childView.getLayoutParams();
                int top = parent.getPaddingTop() + mLeftOrTopPadding;
                int bottom = childView.getBottom() - mRightOrBottomPadding;
                int right = childView.getLeft() - params.leftMargin;
                int left = right - mHeight;
                dividerDrawable.setBounds(left, top, right, bottom);
                dividerDrawable.draw(c);
            }
        }
    }

    protected LinearLayoutManager getLinearLayoutManger(RecyclerView parent) {
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            return (LinearLayoutManager) layoutManager;
        }
        return null;
    }

    protected int getOrientation(RecyclerView parent) {
        LinearLayoutManager layoutManager = getLinearLayoutManger(parent);
        if (layoutManager != null) {
            return layoutManager.getOrientation();
        }
        return -1;
    }

    protected int getOrientation(LinearLayoutManager layoutManager) {
        if (layoutManager != null) {
            return layoutManager.getOrientation();
        }
        return -1;
    }

}