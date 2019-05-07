package com.example.administrator.dbtools.base.network;

public interface INetStatusUI {
    void showError();
    void showContent();
    void showEmpty();
    void showLoading();

    void loadData();
}
