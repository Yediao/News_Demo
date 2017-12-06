package zhixiang.com.news_mvp.module.news.channel;


import zhixiang.com.news_mvp.module.base.IBasePrestenter;
import zhixiang.com.news_mvp.module.base.ILocalPresenter;

/**
 * Created by long on 2016/12/15.
 * 频道 Presenter 接口
 */
public interface IChannelPresenter<T> extends ILocalPresenter<T>,IBasePrestenter {

    /**
     * 交换
     * @param fromPos
     * @param toPos
     */
    void swap(int fromPos, int toPos);
}
