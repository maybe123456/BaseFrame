package com.example.administrator.dbtools.sport.home;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.administrator.dbtools.R;
import com.example.administrator.dbtools.base.BaseFragment;
import com.example.administrator.dbtools.base.network.PageLoadCallback;
import com.example.administrator.dbtools.base.network.ZClient;
import com.example.administrator.dbtools.databinding.FragmentCategoryFashionBinding;
import com.example.administrator.dbtools.sport.SportService;
import com.example.administrator.dbtools.sport.home.adapter.ChessListAdapter;
import com.example.administrator.dbtools.sport.home.bean.ChannerlKey;

/**
 * Created by Administrator on 2018/3/5.
 */

public class CategoryFashionFragment extends BaseFragment<FragmentCategoryFashionBinding> {


    private ChessListAdapter mAdapter;
    private PageLoadCallback callBack;

    private int reqKey = 383;

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_category_fashion;
    }

    @Override
    public void initView() {

        binding.recyclerView.setAdapter(mAdapter = new ChessListAdapter(mContext));
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
//        binding.recyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));
//        binding.recyclerView.setHasFixedSize(true);
        binding.tvCategoryTitle.setText("社会");
        initCallback();
        binding.swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                callBack.onRefresh();
            }
        });
    }

    private void initCallback() {
        callBack = new PageLoadCallback(mAdapter, binding.recyclerView) {
            @Override
            public void requestAction(int page, int limit) {
                ZClient.getService(SportService.class).getNewsSpotrList(reqKey, page, limit).enqueue(callBack);
            }
        };
        callBack.setSwipeRefreshLayout(binding.swipeRefreshLayout);
    }

    @Override
    public void initListener() {
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                startActivity(new Intent(mContext, SimpleWebChessActivity.class).putExtra("id", mAdapter.getItem(position).getId()));
//                startActivity(new Intent(mContext, SimpleWebCommentActivity.class).putExtra("newsId", mAdapter.getItem(position).getNewsId()));
            }
        });
    }


    @Override
    public void onResume() {
        super.onResume();
        callBack.onRefresh();
    }

    @Override
    public void onClick(View view) {

    }

    public void setReqKey(ChannerlKey footballKey) {
        this.reqKey = Integer.parseInt(footballKey.getTypeId());
        binding.tvCategoryTitle.setText(footballKey.getTypeName());
        callBack.onRefresh();
    }
}
