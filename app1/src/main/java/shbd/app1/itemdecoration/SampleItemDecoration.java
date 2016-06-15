package shbd.app1.itemdecoration;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by yh on 2016/6/15.
 * 自定义分隔线
 */
public class SampleItemDecoration extends RecyclerView.ItemDecoration {
    private Context mContext;

    private static final int[] ATTRS = new int[]{android.R.attr.listDivider};

    private Drawable mDivider;

    public SampleItemDecoration(Context context) {
        this.mContext = context;
        TypedArray a = mContext.obtainStyledAttributes(ATTRS);

        //获取分隔线对象
        mDivider = a.getDrawable(0);

        a.recycle();
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent) {
        //分隔线的左坐标
        int left = parent.getPaddingLeft();
        //分隔线的右坐标
        int right = parent.getWidth() - parent.getPaddingRight();

        /**
         * 获取子view的个数
         */
        int childCount = parent.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < parent.getChildCount(); i++) {
                final View childView = parent.getChildAt(i);
                RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) childView.getLayoutParams();
                //分隔线的上顶点
                int top = childView.getBottom() + params.bottomMargin;
                //分隔线的下顶点
                int buttom = top + mDivider.getIntrinsicHeight();
                //设置分隔线的画线的范围
                mDivider.setBounds(left, top, right, buttom);

                mDivider.draw(c);
            }
        }

        super.onDraw(c, parent);
    }
}
