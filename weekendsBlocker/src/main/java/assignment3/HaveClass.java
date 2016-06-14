package assignment3;

import com.google.inject.Guice;
import com.google.inject.Inject;

import java.text.SimpleDateFormat;

public class HaveClass {
    @Inject private Now now;

    @NotOnWeekends
    public void haveClass() {
        String dayOfWeek = new SimpleDateFormat("EEEE").format(now.get());
        System.out.println("I am having class now(" + dayOfWeek + ").");
    }

}