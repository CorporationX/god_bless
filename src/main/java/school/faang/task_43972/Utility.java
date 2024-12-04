package school.faang.task_43972;

import java.util.Calendar;

public class Utility {
    static Calendar cal = Calendar.getInstance();
    static Faker faker = new Faker();
    public static Long getCurrentDateInMilliseconds(){
        return cal.getTimeInMillis();
    }

}
