package shbd.app1.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import shbd.app1.R;
import shbd.app1.viewholder.SimpleViewHolder;

/**
 * Created by yh on 2016/6/14.
 */
public class SimpleAdapter extends RecyclerView.Adapter<SimpleViewHolder> {
    private Context mContext;
    private List<String> mDatas;
    private LayoutInflater mInflater;

    public SimpleAdapter(Context context, List<String> datas) {
        mContext = context;
        mDatas = datas;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.simple_textview, parent, false);
        SimpleViewHolder viewHolder = new SimpleViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {
        holder.mTextView.setText(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    /**
     * 添加条目
     *
     * @param position
     */
    public void addItem(int position) {
        mDatas.add(position,"inserted one");
        notifyItemInserted(position);
    }

    /**
     * 删除条目
     * @param position
     */
    public void deleteItem(int position) {
        mDatas.remove(position);
        notifyItemRemoved(position);
    }
}
