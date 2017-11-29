package zhixiang.com.news_mvp.module.inject;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 *
 * 单例标识
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerFragment {
}
