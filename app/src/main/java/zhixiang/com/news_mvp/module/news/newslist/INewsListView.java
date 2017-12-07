package zhixiang.com.news_mvp.module.news.newslist;



import java.util.List;

import zhixiang.com.news_mvp.adapter.item.NewsMultiItem;
import zhixiang.com.news_mvp.api.bean.NewsInfo;
import zhixiang.com.news_mvp.module.base.ILoadDataView;

/**
 * Created by long on 2016/8/23.
 * 新闻列表视图接口
 */
public interface INewsListView extends ILoadDataView<List<NewsMultiItem>> {

    /**
     * 加载广告数据
     * @param newsBean 新闻
     */
    void loadAdData(NewsInfo newsBean);
}
