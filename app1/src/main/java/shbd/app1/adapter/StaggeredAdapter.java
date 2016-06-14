package shbd.app1.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import shbd.app1.R;
import shbd.app1.viewholder.SimpleViewHolder;

/**
 * Created by yh on 2016/6/14.
 * 瀑布流adapter
 */
public class StaggeredAdapter extends RecyclerView.Adapter<SimpleViewHolder> {
    private Context mContext;
    private List<String> mDatas;
    private LayoutInflater mInflater;

    private List<Integer> mHeights;
    public StaggeredAdapter(Context context, List<String> datas) {
        mContext = context;
        mDatas = datas;
        mHeights=new ArrayList<>();
        for (int i=0;i<mDatas.size();i++){
            mHeights.add((int) (100+Math.random()*300));
        }
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
        /**
         * 为textView设置随机高度
         */
       /* LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) holder.mTextView.getLayoutParams();
        layoutParams.height=mHeights.get(position);
        holder.mTextView.setLayoutParams(layoutParams);*/
        holder.mTextView.setText(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}
