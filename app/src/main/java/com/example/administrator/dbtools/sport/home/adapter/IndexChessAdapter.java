package com.example.administrator.dbtools.sport.home.adapter;

import android.content.Context;
import android.view.View;
import android.widget.CheckedTextView;

import com.example.administrator.dbtools.R;
import com.example.administrator.dbtools.base.adapter.AbsListViewAdapter;
import com.example.administrator.dbtools.sport.home.bean.ChannerlKey;


/**
 * Created by Administrator on 2018/3/5.
 */

public class IndexChessAdapter extends AbsListViewAdapter<ChannerlKey, IndexChessAdapter.ViewHolder> {

    private int selectedPosition;

    public IndexChessAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getItemViewLayoutId() {
        return R.layout.item_index_chess;
    }

    @Override
    protected void bindView(int position, ChannerlKey object, ViewHolder viewHolder) {
        viewHolder.tvIndex.setText(object.getTypeName());
        viewHolder.tvIndex.setChecked(selectedPosition == position);
    }


    @Override
    protected ViewHolder loadHolder(View v) {
        return new ViewHolder(v);
    }

    public void setSelectPosition(int position) {
        this.selectedPosition = position;
        notifyDataSetChanged();
    }

    final class ViewHolder {

        CheckedTextView tvIndex;

        public ViewHolder(View v) {
            tvIndex = (CheckedTextView) v.findViewById(R.id.tvIndex);
        }
    }
}
