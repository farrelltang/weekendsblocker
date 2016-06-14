package assignment3;

import com.google.inject.Inject;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 方法级别拦截器, 如果今日为主日, 则所拦截的方法不得执行
  */
class WeekendsBlocker implements MethodInterceptor {

    @Inject private Now now;

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Calendar calendar = Calendar.getInstance();
        Date now = this.now.get();
        calendar.setTime(now);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEE, MMM d, yyyy");
        if (dayOfWeek == Calendar.SUNDAY | dayOfWeek == Calendar.SATURDAY) {
            String errorMessage =  String.format("Today(%s) is Weekend and you don't have class .", dateFormat.format(now));
            System.err.println(errorMessage);
            throw new IllegalStateException(errorMessage);
        }

        return methodInvocation.proceed();
    }
}
