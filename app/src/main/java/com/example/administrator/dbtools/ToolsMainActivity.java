package com.example.administrator.dbtools;

import android.view.KeyEvent;
import android.view.View;

import com.example.administrator.dbtools.base.BaseActivity;
import com.example.administrator.dbtools.base.util.ToastUtil;
import com.example.administrator.dbtools.databinding.ActivityMainToolsBinding;
import com.example.administrator.dbtools.sport.home.HomeFragment2;

public class ToolsMainActivity extends BaseActivity<ActivityMainToolsBinding> {

    private long lastBackTimer;

    @Override
    public int getLayout() {
        return R.layout.activity_main_tools;
    }

    @Override
    public void initView() {
        hideTitle();
        showContent();
        binding.zRadiogroup.setUp(getSupportFragmentManager(), R.id.container,new HomeFragment2());
//        binding.zRadiogroup.setUp(getSupportFragmentManager(), R.id.container,new HomeFragment2(), new HomeFragment2(),  new HomeFragment2(), new HomeFragment2());
//
    }

    @Override
    public void initListener() {

    }

    @Override
    public void loadData() {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                long timer = System.currentTimeMillis() - lastBackTimer;
                lastBackTimer = System.currentTimeMillis();
                if (timer >= 1000) {
                    ToastUtil.toast("再按一次退出应用");
                    return false;
                }

                break;
            default:
                break;
        }

        return super.onKeyDown(keyCode, event);
    }
}
