package zhixiang.com.news_mvp.module.news.main;


import android.util.Log;

import com.orhanobut.logger.Logger;

import java.util.List;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import zhixiang.com.news_mvp.NewsTypeInfoDao;
import zhixiang.com.news_mvp.local.table.NewsTypeInfo;
import zhixiang.com.news_mvp.module.base.IRxBusPresenter;
import zhixiang.com.news_mvp.rxbus.RxBus;

/**
 * Created by long on 2016/9/1.
 * 主页 Presenter
 */
public class NewsMainPresenter implements IRxBusPresenter {

    private final INewsMainView mView;
    private final NewsTypeInfoDao mDbDao;
    private final RxBus mRxBus;

    public NewsMainPresenter(INewsMainView view, NewsTypeInfoDao dbDao, RxBus rxBus) {
        mView = view;
        mDbDao = dbDao;
        mRxBus = rxBus;
    }

    @Override
    public void getData(boolean isRefresh) {
        mDbDao.queryBuilder().rx().list()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<NewsTypeInfo>>() {
                    @Override
                    public void call(List<NewsTypeInfo> newsTypeBeen) {
                        mView.loadData(newsTypeBeen);
                    }
                });
    }

    @Override
    public void getMoreData() {
    }

    @Override
    public <T> void registerRxBus(Class<T> eventType, Action1<T> action) {
        Subscription subscription = mRxBus.doSubscribe(eventType, action, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Logger.e(throwable.toString());
            }
        });
        mRxBus.addSubscription(this, subscription);
    }

    @Override
    public void unregisterRxBus() {

        mRxBus.unSubscribe(this);
    }
}
