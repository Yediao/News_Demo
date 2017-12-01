package zhixiang.com.news_mvp.inject.module;


import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import zhixiang.com.news_mvp.DaoSession;
import zhixiang.com.news_mvp.rxbus.RxBus;

/**
 * Created by: maoshiyu
 * Time  ：    2017/12/1.
 * Desc  ：
 */
@Module
public class ApplicationModule {

    private final DaoSession mDaoSession;
    private final RxBus mRxBus;
    private  final Context context;
    public ApplicationModule(DaoSession daoSession, RxBus rxBus, Context context) {
        mDaoSession = daoSession;
        mRxBus = rxBus;
        this.context = context;
    }
    @Provides
    @Singleton
    RxBus provideRxBus() {

        return mRxBus;
    }

    @Provides
    @Singleton
    DaoSession provideDaoSession() {
        return mDaoSession;
    }

    @Provides
    @Singleton
    Context provideDaoContext() {
        return context;
    }


}
