package zhixiang.com.news_mvp.module.news.channel;


import java.util.List;

import zhixiang.com.news_mvp.local.table.NewsTypeInfo;

/**
 * Created by long on 2016/9/1.
 * 栏目管理接口
 */
public interface IChannelView {

    /**
     * 显示数据
     * @param checkList     选中栏目
     * @param uncheckList   未选中栏目
     */
    void loadData(List<NewsTypeInfo> checkList, List<NewsTypeInfo> uncheckList);
}
