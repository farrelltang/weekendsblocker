package assignment3;

import java.util.Date;

/**
 * 测试场景下可随意设定当前时间的辅助类
 */
public class DummyNow implements Now {
    private Date date;

    @Override
    public synchronized Date get() {
        return date == null ? new Date() : date;
    }

    @Override
    public synchronized void set(Date date) {
        this.date = date;
    }
}
