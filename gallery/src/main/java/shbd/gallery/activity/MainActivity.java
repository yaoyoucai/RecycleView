package shbd.gallery.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import shbd.gallery.R;
import shbd.gallery.adapter.GalleryAdapter;
import shbd.gallery.view.MyRecyclerView;

public class MainActivity extends AppCompatActivity {
    private List<Integer> mDatas;

    private MyRecyclerView mRecyclerView;

    private GalleryAdapter mAdapter;

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initView() {
        mRecyclerView = (MyRecyclerView) findViewById(R.id.id_recyclerview_horizontal);
        mImageView = (ImageView) findViewById(R.id.id_imageview);

        //设置布局管理器
        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);

        mRecyclerView.setLayoutManager(manager);

        //设置适配器
        mAdapter = new GalleryAdapter(getApplicationContext(), mDatas);

        //给适配器设置点击事件
        mAdapter.setOnItemClickListener(new GalleryAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });

        mRecyclerView.setOnItemScrollListener(new MyRecyclerView.OnItemScrollListener() {
            @Override
            public void onChange(int position) {
                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                mImageView.setImageResource(mDatas.get(position));
            }
        });

        mRecyclerView.setAdapter(mAdapter);
    }


    private void initData() {
        mDatas = Arrays.asList(R.mipmap.a, R.mipmap.b, R.mipmap.c, R.mipmap.d, R.mipmap.e, R.mipmap.f, R.mipmap.g, R.mipmap.h);
    }
}
