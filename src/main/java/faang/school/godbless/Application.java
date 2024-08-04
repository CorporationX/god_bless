package faang.school.godbless;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

public class Application {
    public static void main(String[] args) {
        System.out.println("God Bless!");
        Instant currentDate1 = Instant.now();
        Instant currentDate2 = Instant.now();

        System.out.println(currentDate2.getNano());
        System.out.println(currentDate1.getNano());

    }
}