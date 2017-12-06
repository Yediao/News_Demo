package zhixiang.com.news_mvp.inject.module;

import com.dl7.recycler.adapter.BaseQuickAdapter;

import dagger.Module;
import dagger.Provides;
import zhixiang.com.news_mvp.DaoSession;
import zhixiang.com.news_mvp.adapter.ManageAdapter;
import zhixiang.com.news_mvp.inject.PerActivity;
import zhixiang.com.news_mvp.module.news.channel.ChannelActivity;
import zhixiang.com.news_mvp.module.news.channel.ChannelPresenter;
import zhixiang.com.news_mvp.module.news.channel.IChannelPresenter;
import zhixiang.com.news_mvp.rxbus.RxBus;

/**
 * Created by: maoshiyu
 * Time  ：    2017/12/6.
 * Desc  ：
 */
@Module
public class ChannelModule {
    private final ChannelActivity mView;

    public ChannelModule(ChannelActivity view) {
        mView = view;
    }

    @Provides
    public BaseQuickAdapter provideManageAdapter() {
        return new ManageAdapter(mView);
    }

    @PerActivity
    @Provides
    public IChannelPresenter provideManagePresenter(DaoSession daoSession, RxBus rxBus) {
        return new ChannelPresenter(mView, daoSession.getNewsTypeInfoDao(), rxBus);
    }
}
