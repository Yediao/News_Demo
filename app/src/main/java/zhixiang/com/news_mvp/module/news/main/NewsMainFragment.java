package zhixiang.com.news_mvp.module.news.main;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import rx.functions.Action1;
import zhixiang.com.news_mvp.R;
import zhixiang.com.news_mvp.adapter.ViewPagerAdapter;
import zhixiang.com.news_mvp.inject.components.DaggerNewsMainComponent;
import zhixiang.com.news_mvp.inject.module.NewsMainModule;
import zhixiang.com.news_mvp.local.table.NewsTypeInfo;
import zhixiang.com.news_mvp.module.base.BaseFragment;
import zhixiang.com.news_mvp.module.base.IRxBusPresenter;
import zhixiang.com.news_mvp.module.news.channel.ChannelActivity;
import zhixiang.com.news_mvp.module.news.newslist.NewsListFragment;
import zhixiang.com.news_mvp.rxbus.ChannelEvent;

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

    @Inject
    ViewPagerAdapter mPagerAdapter;

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
        mViewPager.setAdapter(mPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mPresenter.registerRxBus(ChannelEvent.class, new Action1<ChannelEvent>() {
            @Override
            public void call(ChannelEvent channelEvent) {
                _handleChannelEvent(channelEvent);
            }
        });
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
    public void onDestroy() {
        super.onDestroy();
        mPresenter.unregisterRxBus();
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_channel, menu);
    }
    @Override
    protected void updateViews(boolean isRefresh) {

        mPresenter.getData(isRefresh);
    }

    @Override
    public void loadData(List<NewsTypeInfo> checkList) {
        List<Fragment> fragments = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        for (NewsTypeInfo bean : checkList) {
            titles.add(bean.getName());
            fragments.add(NewsListFragment.newInstance(bean.getTypeId()));
        }
        mPagerAdapter.setItems(fragments, titles);
    }




    /**
     * 处理频道事件
     * @param channelEvent
     */
    private void _handleChannelEvent(ChannelEvent channelEvent) {
        switch (channelEvent.eventType) {
            case ChannelEvent.ADD_EVENT:
                mPagerAdapter.addItem(NewsListFragment.newInstance(channelEvent.newsInfo.getTypeId()), channelEvent.newsInfo.getName());
                break;
            case ChannelEvent.DEL_EVENT:
                // 如果是删除操作直接切换第一项，不然容易出现加载到不存在的Fragment
                mViewPager.setCurrentItem(0);
                mPagerAdapter.delItem(channelEvent.newsInfo.getName());
                break;
            case ChannelEvent.SWAP_EVENT:
                mPagerAdapter.swapItems(channelEvent.fromPos, channelEvent.toPos);
                break;
        }
    }
}
