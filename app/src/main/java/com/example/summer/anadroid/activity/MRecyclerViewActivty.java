package com.example.summer.anadroid.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.example.summer.anadroid.MainActivity;
import com.example.summer.anadroid.R;
import com.example.summer.anadroid.adapter.DividerItemDecoration;
import com.example.summer.anadroid.adapter.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MRecyclerViewActivty extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mRecyclerViewAdapter;
    private List<String> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mrecyclerview);
        initData();
        mRecyclerView = findViewById(R.id.recyclerview);
        //  设置布局管理器纵向
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //  添加分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        //  设置布局管理器横向
//        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(
//                4,StaggeredGridLayoutManager.VERTICAL));
        mRecyclerViewAdapter = new RecyclerViewAdapter(MRecyclerViewActivty.this, mList);
        mRecyclerViewAdapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, final int position) {
                new AlertDialog.Builder(MRecyclerViewActivty.this)
                        .setTitle("确认删除吗？")
                        .setNegativeButton("取消", null)
                        .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mRecyclerViewAdapter.removeData(position);
                            }
                        }).show();
            }

            @Override
            public void onItemLongClick(View view, final int position) {
                mRecyclerViewAdapter.removeData(position);
            }
        });
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
    }
    private void initData() {
        for (int i = 0; i <= 100; i++) {
            String a = "" + i;
            mList.add(a);
        }
    }
}
