package zhixiang.com.news_mvp.inject.module;

import dagger.Module;
import dagger.Provides;
import zhixiang.com.news_mvp.DaoSession;
import zhixiang.com.news_mvp.inject.PerFragment;
import zhixiang.com.news_mvp.module.base.IRxBusPresenter;
import zhixiang.com.news_mvp.module.news.NewsMainPresenter;
import zhixiang.com.news_mvp.module.news.main.NewsMainFragment;
import zhixiang.com.news_mvp.rxbus.RxBus;

/**
 * Created by: maoshiyu
 * Time  ：    2017/12/5.
 * Desc  ：
 */
@Module
public class NewsMainModule {
    private final NewsMainFragment mView;

    public NewsMainModule(NewsMainFragment view) {
        mView = view;
    }

    @PerFragment
    @Provides
    public IRxBusPresenter provideMainPresenter(DaoSession daoSession, RxBus rxBus) {
        return new NewsMainPresenter(mView, daoSession.getNewsTypeInfoDao(), rxBus);
    }


}
