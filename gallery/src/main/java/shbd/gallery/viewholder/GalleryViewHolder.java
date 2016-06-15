package shbd.gallery.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import shbd.gallery.R;

/**
 * Created by yh on 2016/6/15.
 * 画廊控件的viewholder
 */
public class GalleryViewHolder extends RecyclerView.ViewHolder {
    public TextView mTextView;
    public ImageView mImageView;

    public GalleryViewHolder(View itemView) {
        super(itemView);

        mTextView = (TextView) itemView.findViewById(R.id.id_index_gallery_item_text);
        mImageView = (ImageView) itemView.findViewById(R.id.id_index_gallery_item_image);

    }
}
