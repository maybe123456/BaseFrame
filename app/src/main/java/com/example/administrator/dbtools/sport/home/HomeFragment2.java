package com.example.administrator.dbtools.sport.home;



import android.view.View;
import android.widget.AdapterView;


import com.example.administrator.dbtools.R;
import com.example.administrator.dbtools.base.BaseFragment;
import com.example.administrator.dbtools.base.network.ZCallback;
import com.example.administrator.dbtools.base.network.ZClient;
import com.example.administrator.dbtools.base.network.ZResponse;
import com.example.administrator.dbtools.databinding.Fragment2FashionBinding;
import com.example.administrator.dbtools.sport.SportService;
import com.example.administrator.dbtools.sport.home.adapter.IndexChessAdapter;
import com.example.administrator.dbtools.sport.home.bean.ChannerlKey;

import java.util.List;


public class HomeFragment2 extends BaseFragment<Fragment2FashionBinding> {

    private IndexChessAdapter indexAdapter;

    private CategoryFashionFragment detailFragment;


    @Override
    public int getLayout() {
        return R.layout.fragment2_fashion;
    }

    @Override
    public void initView() {
        indexAdapter = new IndexChessAdapter(mContext);
        binding.indexListView.setAdapter(indexAdapter);
        detailFragment = (CategoryFashionFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.categoryFashionFragment);
        setShowTitle(false);
        reqData();
    }

    private void reqData() {
        ZClient.getService(SportService.class).getSearchKeys().enqueue(new ZCallback<ZResponse<List<ChannerlKey>>>() {
            @Override
            public void onSuccess(ZResponse<List<ChannerlKey>> data) {
                indexAdapter.update(data.getData());
            }
        });
    }

    @Override
    public void initListener() {
        binding.indexListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long itemId) {
                indexAdapter.setSelectPosition(position);
                detailFragment.setReqKey(indexAdapter.getItem(position));
            }
        });
    }


    @Override
    public void onClick(View view) {

    }
}
