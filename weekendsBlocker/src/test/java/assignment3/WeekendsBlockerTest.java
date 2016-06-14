package assignment3;

import com.google.inject.Inject;
import org.apache.commons.lang3.time.DateUtils;
import org.jukito.JukitoRunner;
import org.jukito.UseModules;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(JukitoRunner.class)
@UseModules({NotOnWeekendsModule.class, DummyDateModule.class})
public class WeekendsBlockerTest {
    @Inject private HaveClass haveClass;
    @Inject private Now now;

    @Test(expected = IllegalStateException.class)
    public void blockedOnWeekends() throws ParseException {
        now.set(new SimpleDateFormat("yyyy-M-d").parse("2016-6-11"));
        haveClass.haveClass();
    }

    @Test(expected = IllegalStateException.class)
    public void blockedOnWeekends2() throws ParseException {
        now.set(new SimpleDateFormat("yyyy-M-d").parse("2016-6-12"));
        haveClass.haveClass();
    }

    @Test
    public void notBlockedOnMonday() throws ParseException {
        Date monday = new SimpleDateFormat("yyyy-M-d").parse("2016-6-13");
        for (int i = 0; i < 5; i++) {
            now.set(DateUtils.addDays(monday, i));
            haveClass.haveClass();
        }
    }
}