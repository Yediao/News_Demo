package zhixiang.com.news_mvp.inject.module;


import com.dl7.recycler.adapter.BaseQuickAdapter;

import dagger.Module;
import dagger.Provides;
import zhixiang.com.news_mvp.adapter.NewsMultiListAdapter;
import zhixiang.com.news_mvp.inject.PerFragment;
import zhixiang.com.news_mvp.module.base.IBasePresenter;
import zhixiang.com.news_mvp.module.news.newslist.NewsListFragment;
import zhixiang.com.news_mvp.module.news.newslist.NewsListPresenter;

/**
 * Created by long on 2016/8/23.
 * 新闻列表 Module
 */
@Module
public class NewsListModule {

    private final NewsListFragment mNewsListView;
    private final String mNewsId;

    public NewsListModule(NewsListFragment view, String newsId) {
        this.mNewsListView = view;
        this.mNewsId = newsId;
    }

    @PerFragment
    @Provides
    public IBasePresenter providePresenter() {
        return new NewsListPresenter(mNewsListView, mNewsId);
    }

    @PerFragment
    @Provides
    public BaseQuickAdapter provideAdapter() {
        return new NewsMultiListAdapter(mNewsListView.getContext());
    }
}
