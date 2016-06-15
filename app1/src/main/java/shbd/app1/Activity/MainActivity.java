package shbd.app1.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import shbd.app1.R;
import shbd.app1.adapter.SimpleAdapter;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<String> mDatas;

    private SimpleAdapter mAdapter;

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.inflateMenu(R.menu.menu);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.listview:
                        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        break;
                    case R.id.gridview:
                        mRecyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));
                        break;
                    case R.id.hor_gridview:
                        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.HORIZONTAL));
                        break;
                    case R.id.staggeredview:
                        Intent intent = new Intent(MainActivity.this, StaggeredActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.add:
                        mAdapter.addItem(1);
                        break;
                    case R.id.delete:
                        mAdapter.deleteItem(1);
                        break;
                }
                return false;
            }
        });
        mAdapter = new SimpleAdapter(getApplicationContext(), mDatas);

        /**
         * 给recyclerView设置点击事件
         */
        mAdapter.setOnclickListener(new SimpleAdapter.OnClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(MainActivity.this,position+"", Toast.LENGTH_SHORT).show();
            }
        });

        mRecyclerView.setAdapter(mAdapter);

        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);
        /**
         * 添加分隔线
         */
        /*DividerItemDecoration itemDecoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL_LIST);
        mRecyclerView.addItemDecoration(itemDecoration);*/
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void initData() {
        mDatas = new ArrayList<>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i);
        }
    }

}
