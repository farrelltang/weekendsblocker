package assignment3;

import java.lang.annotation.*;

/**
 * 注解: 拦阻方法在主日执行
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface NotOnWeekends {

}
