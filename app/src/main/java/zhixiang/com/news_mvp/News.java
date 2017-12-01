package zhixiang.com.news_mvp;

import android.app.Application;
import android.content.Context;

import org.greenrobot.greendao.database.Database;

import zhixiang.com.news_mvp.api.RetrofitService;
import zhixiang.com.news_mvp.inject.components.DaggerApplicationComponent;
import zhixiang.com.news_mvp.inject.module.ApplicationModule;
import zhixiang.com.news_mvp.rxbus.RxBus;
import zhixiang.com.news_mvp.utils.ToastUtils;

/**
 * Created by: maoshiyu
 * Time  ：    2017/11/23.
 * Desc  ：
 */

public class News extends Application {
    private static final String DB_NAME = "news-db";
    // 因为下载那边需要用，这里在外面实例化在通过 ApplicationModule 设置
    private RxBus mRxBus = new RxBus();
    private static Context sContext;
    private DaoSession mDaoSession;
    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
        _initDatabase();
        _initConfig();
    }
    public static Context getContext() {
        return sContext;
    }

    /**
     * 初始化数据库
     */
    private void _initDatabase() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(getApplicationContext(), DB_NAME);
        Database database = helper.getWritableDb();
        mDaoSession = new DaoMaster(database).newSession();
//        NewsTypeDao.updateLocalData(getApplication(), mDaoSession);
//        DownloadUtils.init(mDaoSession.getBeautyPhotoInfoDao());
    }

    /**
     * 初始化注射器
     */
    private void _initInjector() {
        // 这里不做注入操作，只提供一些全局单例数据
                            DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule( mDaoSession, mRxBus, sContext))
                .build();

    }
    /**
     * 初始化配置
     */
    private void _initConfig() {
//        if (BuildConfig.DEBUG) {
//            LeakCanary.install(getApplication());
//            Logger.init("LogTAG");
//        }
//        CrashHandler.getInstance().init(getApplication());
        RetrofitService.init();
        ToastUtils.init(getApplicationContext());
//        DownloaderWrapper.init(mRxBus, mDaoSession.getVideoInfoDao());
//        FileDownloader.init(getApplication());
//        DownloadConfig config = new DownloadConfig.Builder()
//                .setDownloadDir(PreferencesUtils.getSavePath(getApplication()) + File.separator + "video/").build();
//        FileDownloader.setConfig(config);
    }

}
