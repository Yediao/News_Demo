package zhixiang.com.news_mvp.inject.components;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import zhixiang.com.news_mvp.DaoSession;
import zhixiang.com.news_mvp.inject.module.ApplicationModule;
import zhixiang.com.news_mvp.rxbus.RxBus;

/**
 * Created by long on 2016/8/19.
 * Application Component
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

//    void inject(BaseActivity baseActivity);

    // provide
    Context getContext();
    RxBus getRxBus();
    DaoSession getDaoSession();
}
