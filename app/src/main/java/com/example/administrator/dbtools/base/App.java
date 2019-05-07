package com.example.administrator.dbtools.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.multidex.MultiDex;

import com.example.administrator.dbtools.base.adapter.ZActivityLifecycleCallbacks;
import com.example.administrator.dbtools.base.util.CommonUtils;
import com.example.administrator.dbtools.base.util.ContextHolder;
import com.example.administrator.dbtools.base.util.ZDisplayer;
import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.view.CropImageView;

import org.litepal.LitePal;

import java.util.Stack;


/**
 * Created by Administrator on 2018/2/28.
 */

public class App extends Application {
    private static App app;
    private static Stack<Activity> activityStack;
    private Typeface albbTypeFace;
    public static Context applicationContext;
    private static App instance;
    // login user name
    public final String PREF_USERNAME = "username";

    /**
     * nickname for current user, the nickname instead of ID be shown when user receive notification from APNs
     */
    public static String currentUserNick = "";

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        AppConfig.APP_ID = getPackageName();
        AppConfig.USER_ID = CommonUtils.getUserId();
        applicationContext = this;
        instance = this;


        initImagePicker();
    }


    private void initImagePicker() {
        ImagePicker imagePicker = ImagePicker.getInstance();
        imagePicker.setImageLoader(new ZDisplayer());   //设置图片加载器
        imagePicker.setShowCamera(true);  //显示拍照按钮
        imagePicker.setCrop(true);        //允许裁剪（单选才有效）
        imagePicker.setSaveRectangle(true); //是否按矩形区域保存
        imagePicker.setSelectLimit(1);    //选中数量限制
        imagePicker.setStyle(CropImageView.Style.CIRCLE);  //裁剪框的形状
        imagePicker.setFocusWidth(800);   //裁剪框的宽度。单位像素（圆形自动取宽高最小值）
        imagePicker.setFocusHeight(800);  //裁剪框的高度。单位像素（圆形自动取宽高最小值）
        imagePicker.setOutPutX(1000);//保存文件的宽度。单位像素
        imagePicker.setOutPutY(1000);//保存文件的高度。单位像素
    }


    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
        ContextHolder.init(this);
        registerActivityLifecycleCallbacks(new ZActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

                if (activityStack == null) {
                    activityStack = new Stack<>();
                }
                activityStack.add(activity);
            }

            @Override
            public void onActivityDestroyed(Activity activity) {

                if (activity != null) activityStack.remove(activity);
            }
        });
        initTypeFace();
        initLitePalDB();
    }

    public void initLitePalDB(){
        LitePal.initialize(this);
    }


    public static App getApp() {
        return app;
    }

    private void initTypeFace() {
        albbTypeFace = Typeface.createFromAsset(getAssets(), "iconfont.ttf");
    }

    public Typeface getTypeFace() {
        return albbTypeFace;
    }


    /**
     * 结束全部的Activity
     */
    public void finishAllActivity() {
        if (activityStack != null && activityStack.size() > 0) {
            for (int i = 0, size = activityStack.size(); i < size; i++) {
                if (null != activityStack.get(i)) {
                    activityStack.get(i).finish();
                }
            }
            activityStack.clear();
        }
    }

    public static void exit(boolean autoLogin) {
//        SQLiteUtil.saveBoolean(SQLiteKey.AUTOLOGIN + CommonUtils.getUserId(), autoLogin);
//        if (!autoLogin) {
//            SQLiteUtil.saveString(SQLiteKey.USER, "");
//        }
        app.finishAllActivity();
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

}
