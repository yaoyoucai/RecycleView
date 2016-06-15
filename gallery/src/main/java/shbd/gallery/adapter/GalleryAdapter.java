package shbd.gallery.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import shbd.gallery.R;
import shbd.gallery.viewholder.GalleryViewHolder;

/**
 * Created by yh on 2016/6/15.
 * 画廊控件的adapter
 */
public class GalleryAdapter extends RecyclerView.Adapter<GalleryViewHolder> {
    private LayoutInflater mInfalter;

    private List<Integer> mDatas;

    public GalleryAdapter(Context context, List<Integer> datas) {
        this.mDatas = datas;
        this.mInfalter = LayoutInflater.from(context);
    }

    /**
     * 创建viewHolder
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public GalleryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInfalter.inflate(R.layout.item, parent, false);
        final GalleryViewHolder viewHolder = new GalleryViewHolder(view);

        //设置点击事件
        viewHolder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    int layoutPosition = viewHolder.getLayoutPosition();
                    mListener.onClick(layoutPosition);
                }
            }
        });
        return viewHolder;
    }

    /**
     * 为viewHolder中的组件赋值
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(GalleryViewHolder holder, int position) {
        holder.mImageView.setImageResource(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }


    private OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    public interface OnItemClickListener {
        void onClick(int position);
    }
}