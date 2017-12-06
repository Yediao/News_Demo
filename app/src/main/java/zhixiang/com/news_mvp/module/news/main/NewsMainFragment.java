package zhixiang.com.news_mvp.module.news.main;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.orhanobut.logger.Logger;

import java.util.List;

import butterknife.BindView;
import zhixiang.com.news_mvp.R;
import zhixiang.com.news_mvp.inject.components.DaggerNewsMainComponent;
import zhixiang.com.news_mvp.inject.module.NewsMainModule;
import zhixiang.com.news_mvp.local.table.NewsTypeInfo;
import zhixiang.com.news_mvp.module.base.BaseFragment;
import zhixiang.com.news_mvp.module.base.IRxBusPresenter;
import zhixiang.com.news_mvp.module.news.INewsMainView;
import zhixiang.com.news_mvp.module.news.channel.ChannelActivity;

/**
 * Created by: maoshiyu
 * Time  ：    2017/12/5.
 * Desc  ：
 */

public class NewsMainFragment extends BaseFragment<IRxBusPresenter> implements INewsMainView {
    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_news_main;
    }

    @Override
    protected void initInjector() {
        DaggerNewsMainComponent.builder()
                .applicationComponent(getAppComponent())
                .newsMainModule(new NewsMainModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void initViews() {
        initToolBar(mToolBar, true, "新闻");
        setHasOptionsMenu(true);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.item_channel) {
            ChannelActivity.launch(mContext);
            return true;
        }
        return false;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_channel, menu);
    }
    @Override
    protected void updateViews(boolean isRefresh) {

    }

    @Override
    public void loadData(List<NewsTypeInfo> checkList) {

    }

    @Override
    public void onRetry() {

    }
}
