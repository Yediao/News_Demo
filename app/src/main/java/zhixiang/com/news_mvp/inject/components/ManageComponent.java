package zhixiang.com.news_mvp.inject.components;



import dagger.Component;
import zhixiang.com.news_mvp.inject.PerActivity;
import zhixiang.com.news_mvp.inject.module.ChannelModule;
import zhixiang.com.news_mvp.module.news.channel.ChannelActivity;

/**
 * Created by long on 2016/8/31.
 * 管理 Component
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ChannelModule.class)
public interface ManageComponent {
    void inject(ChannelActivity activity);
}
