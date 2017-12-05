package zhixiang.com.news_mvp.module.base;

import rx.functions.Action1;
import zhixiang.com.news_mvp.module.base.IBasePrestenter;

/**
 * .
 * RxBus Presenter
 */
public interface IRxBusPresenter extends IBasePrestenter {

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
