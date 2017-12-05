package zhixiang.com.news_mvp.inject.components;

import android.app.Activity;


import dagger.Component;
import zhixiang.com.news_mvp.inject.PerActivity;
import zhixiang.com.news_mvp.inject.module.ActivityModule;

/**
 * Created by long on 2016/8/19.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();
}
