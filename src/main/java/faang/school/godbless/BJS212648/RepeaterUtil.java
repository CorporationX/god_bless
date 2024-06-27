package faang.school.godbless.BJS212648;

import lombok.experimental.UtilityClass;

import java.util.function.Supplier;

@UtilityClass
public class RepeaterUtil {

    public static void repeat(Supplier<Integer> supplier, Runnable runnable) {
        while (true) {
            try {
                Thread.sleep(supplier.get() * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            runnable.run();
        }
    }
}
