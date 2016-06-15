package shbd.gallery.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by yh on 2016/6/15.
 * 自定义recyclerView
 */
public class MyRecyclerView extends RecyclerView {
    //当前大图显示的view
    private View mCurrentView;

    public MyRecyclerView(Context context) {
        super(context);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        switch (e.getAction()) {
            case MotionEvent.ACTION_MOVE:
                mCurrentView = getChildAt(0);
                if (mListener != null) {
                    mListener.onChange(getChildLayoutPosition(mCurrentView));
                }
                break;
        }
        return super.onTouchEvent(e);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        mCurrentView = getChildAt(0);
        if (mListener != null) {
            mListener.onChange(getChildLayoutPosition(mCurrentView));
        }
    }

    private OnItemScrollListener mListener;

    public void setOnItemScrollListener(OnItemScrollListener listener) {
        this.mListener = listener;
    }

    public interface OnItemScrollListener {
        void onChange(int position);
    }
}
