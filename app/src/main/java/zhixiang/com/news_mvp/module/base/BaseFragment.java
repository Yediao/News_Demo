package zhixiang.com.news_mvp.module.base;

import com.trello.rxlifecycle.LifecycleTransformer;
import com.trello.rxlifecycle.components.support.RxFragment;

import zhixiang.com.news_mvp.widget.EmptyLayout;

/**
 * Created by: maoshiyu
 * Time  ：    2017/12/5.
 * Desc  ：
 */

public abstract class BaseFragment<T extends  IBasePrestenter> extends RxFragment implements  IBaseView,EmptyLayout.OnRetryListener {

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showNetError() {

    }

    @Override
    public void finishRefresh() {

    }

    @Override
    public <T> LifecycleTransformer<T> bindToLife() {
        return this.<T>bindToLifecycle();
    }


    /**
     * 绑定布局文件
     * @return  布局文件ID
     */
    protected abstract int attachLayoutRes();

    /**
     * Dagger 注入
     */
    protected abstract void initInjector();

    /**
     * 初始化视图控件
     */
    protected abstract void initViews();

    /**
     * 更新视图控件
     * @param isRefresh 新增参数，用来判断是否为下拉刷新调用，下拉刷新的时候不应该再显示加载界面和异常界面
     */
    protected abstract void updateViews(boolean isRefresh);
}
