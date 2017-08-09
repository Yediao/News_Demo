package zhixiang.com.news_mvp.module.base;

import rx.functions.Action1;

/**
 * Created by: maoshiyu
 * Time  ：    2017/8/9.
 * Desc  ：RxBus Presenter
 */

public interface IRxBusPresenter {
    /**
     * 注册
     * @param eventType
     * @param <T>
     */
    <T> void registerRxBus(Class<T> eventType, Action1<T> action);

    /**
     * 注销
     */
    void unregisterRxBus();
}
