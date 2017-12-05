package zhixiang.com.news_mvp.module.home;

import android.widget.Toast;

import zhixiang.com.news_mvp.R;
import zhixiang.com.news_mvp.module.base.BaseActivity;
import zhixiang.com.news_mvp.module.news.main.NewsMainFragment;

/**
 * Created by: maoshiyu
 * Time  ：    2017/11/29.
 * Desc  ：
 */

public class Home_Activity extends BaseActivity {
    private long mExitTime = 0;
    @Override
    protected int attachLayoutRes() {

        return R.layout.activity_home;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void updateViews(boolean isRefresh) {
        addFragment(R.id.fl_container, new NewsMainFragment(), "News");
    }

    @Override
    public void onRetry() {

    }

    /**
     * 退出
     */
    private void _exit() {
        if (System.currentTimeMillis() - mExitTime > 2000) {
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            mExitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }
}
