package zhixiang.com.news_mvp.module.home;

import android.os.Bundle;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zhixiang.com.news_mvp.R;
import zhixiang.com.news_mvp.module.base.BaseActivity;
import zhixiang.com.news_mvp.widget.SimpleButton;

/**
 * Created by: maoshiyu
 * Time  ：    2017/11/23.
 * Desc  ：开机界面
 */

public class Welcome_Activity extends BaseActivity {


    @BindView(R.id.sb_skip)
    SimpleButton sbSkip;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_welcome;
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


    @OnClick(R.id.sb_skip)
    public void onViewClicked() {
    }
}
