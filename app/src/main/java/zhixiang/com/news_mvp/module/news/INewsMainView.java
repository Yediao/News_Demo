package zhixiang.com.news_mvp.module.news;

import java.util.List;

import zhixiang.com.news_mvp.local.table.NewsTypeInfo;

/**
 * Created by: maoshiyu
 * Time  ：    2017/11/29.
 * Desc  ：
 */

public interface INewsMainView {

    /**
     * 显示数据
     * @param checkList     选中栏目
     */
    void loadData(List<NewsTypeInfo> checkList);

}
