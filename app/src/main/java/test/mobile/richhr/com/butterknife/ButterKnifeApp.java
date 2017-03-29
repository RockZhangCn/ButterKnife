package test.mobile.richhr.com.butterknife;

import android.app.Application;
import android.content.Context;

import java.io.File;

import cn.jpush.android.api.JPushInterface;
import test.mobile.richhr.com.butterknife.api.RetrofitService;

/**
 * Created by rock on 16-2-25.
 */
public class ButterKnifeApp extends Application
{
    private static Context mAppContext;
    private static ButterKnifeApp m_singleInstance;
    private File mAppStoreDir;

    public static ButterKnifeApp getInstance()
    {
        return m_singleInstance;
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        m_singleInstance = this;
        mAppContext = m_singleInstance;
        RetrofitService.init(mAppContext);
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);

    }

    public Context getApplicationContext()
    {
        return mAppContext;
    }


}
