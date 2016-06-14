package assignment3;

import com.google.inject.AbstractModule;

/**
 * 测试场景日期模块定义
 */
public class DummyDateModule extends AbstractModule {

    protected void configure() {
        this.bind(Now.class).to(DummyNow.class).asEagerSingleton();
    }

}
