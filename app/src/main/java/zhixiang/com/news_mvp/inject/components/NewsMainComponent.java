package zhixiang.com.news_mvp.inject.components;


import dagger.Component;
import zhixiang.com.news_mvp.inject.PerFragment;
import zhixiang.com.news_mvp.inject.module.NewsMainModule;
import zhixiang.com.news_mvp.module.news.main.NewsMainFragment;

/**
 *
 * 主页 Component
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = NewsMainModule.class)
public interface NewsMainComponent {
    void inject(NewsMainFragment fragment);
}
