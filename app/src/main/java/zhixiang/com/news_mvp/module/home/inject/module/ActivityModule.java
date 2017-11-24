package zhixiang.com.news_mvp.module.home.inject.module;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import zhixiang.com.news_mvp.module.home.inject.PerActivity;

/**
 * Created by: maoshiyu
 * Time  ：    2017/11/24.
 * Desc  ：
 */

@Module
public class ActivityModule {

    private final Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @PerActivity
    @Provides
    Activity getActivity() {

        return mActivity;
    }
}
