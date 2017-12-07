package zhixiang.com.news_mvp.inject.components;


import dagger.Component;
import zhixiang.com.news_mvp.inject.PerFragment;
import zhixiang.com.news_mvp.inject.module.NewsListModule;
import zhixiang.com.news_mvp.module.news.newslist.NewsListFragment;

/**
 * Created by long on 2016/8/23.
 * 新闻列表 Component
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = NewsListModule.class)
public interface NewsListComponent {
    void inject(NewsListFragment fragment);
}
