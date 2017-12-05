package zhixiang.com.news_mvp.module.news.main;

import java.util.List;

import zhixiang.com.news_mvp.R;
import zhixiang.com.news_mvp.local.table.NewsTypeInfo;
import zhixiang.com.news_mvp.module.base.BaseFragment;
import zhixiang.com.news_mvp.module.base.IRxBusPresenter;
import zhixiang.com.news_mvp.module.news.INewsMainView;

/**
 * Created by: maoshiyu
 * Time  ：    2017/12/5.
 * Desc  ：
 */

public class NewsMainFragment extends BaseFragment<IRxBusPresenter> implements INewsMainView {

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_news_main;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initViews() {

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
