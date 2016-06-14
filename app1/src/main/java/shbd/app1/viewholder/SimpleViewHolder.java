package shbd.app1.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import shbd.app1.R;

/**
 * Created by yh on 2016/6/14.
 */
public class SimpleViewHolder extends RecyclerView.ViewHolder {
    public TextView mTextView;
    public SimpleViewHolder(View itemView) {
        super(itemView);
        mTextView= (TextView) itemView.findViewById(R.id.textview);
    }
}
