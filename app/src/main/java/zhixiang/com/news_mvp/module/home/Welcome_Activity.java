package zhixiang.com.news_mvp.module.home;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;
import zhixiang.com.news_mvp.R;
import zhixiang.com.news_mvp.module.MainActivity;
import zhixiang.com.news_mvp.module.base.BaseActivity;
import zhixiang.com.news_mvp.utils.RxHelper;
import zhixiang.com.news_mvp.widget.SimpleButton;

/**
 * Created by: maoshiyu
 * Time  ：    2017/11/23.
 * Desc  ：开机界面
 */

public class Welcome_Activity extends BaseActivity {


    @BindView(R.id.sb_skip)
    SimpleButton sbSkip;
    private boolean mIsSkip = false;
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
        RxHelper.countdown(60)
                .compose(this.<Integer>bindToLifecycle())
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                        _doSkip();
                    }

                    @Override
                    public void onError(Throwable e) {

                        _doSkip();
                    }

                    @Override
                    public void onNext(Integer integer) {
                        sbSkip.setText("跳过 " + integer);
                    }
                });
    }


    private void _doSkip() {
        if (!mIsSkip) {
            mIsSkip = true;
            finish();
            startActivity(new Intent(Welcome_Activity.this, Home_Activity.class));
            overridePendingTransition(R.anim.hold, R.anim.zoom_in_exit);
        }
    }
    @Override
    public void onBackPressed() {
        // 不响应后退键
        return;
    }

    @OnClick(R.id.sb_skip)
    public void onViewClicked() {
        _doSkip();
    }
}
