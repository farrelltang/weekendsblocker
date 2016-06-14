package assignment3;

import com.google.inject.Inject;
import org.jukito.JukitoRunner;
import org.jukito.UseModules;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RunWith(JukitoRunner.class)
//use DummyDateModule,so that you can set the date
@UseModules({DummyDateModule.class})
public class HaveClassTest {
    @Inject private HaveClass haveClass;
    @Inject private Now now;

    @Test
    public void haveClass() throws ParseException {
        now.set(new SimpleDateFormat("yyyy-M-d").parse("2016-6-13"));
        haveClass.haveClass();

        now.set(new SimpleDateFormat("yyyy-M-d").parse("2016-6-14"));
        haveClass.haveClass();
    }
}
