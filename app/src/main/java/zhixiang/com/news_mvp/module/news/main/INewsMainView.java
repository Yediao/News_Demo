package zhixiang.com.news_mvp.module.news.main;

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
 * Created by: maoshiyu
 * Time  ：    2017/11/29.
 * Desc  ：
 */

public interface INewsMainView {

    /**
     * 显示数据
     * @param checkList     选中栏目
     */
    void loadData(List<NewsTypeInfo> checkList);


}
