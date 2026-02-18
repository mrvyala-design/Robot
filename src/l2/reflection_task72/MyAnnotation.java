package l2.reflection_task72;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class MyAnnotation {

    @Retention(RetentionPolicy.RUNTIME)
    public @interface academyinfo {
        public int year();
    }

    public void doSmth() {
    }

    @academyinfo(year = 5)
    public void work(){
    }
}
