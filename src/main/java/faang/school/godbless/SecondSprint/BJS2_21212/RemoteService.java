package faang.school.godbless.SecondSprint.BJS2_21212;

import java.util.concurrent.ThreadLocalRandom;

public class RemoteService {
    public int call(int param) {
        int result = ThreadLocalRandom.current().nextInt(1, 5);
        if (result > param) {
            return  result *= result;
        } else {
            throw new IllegalArgumentException("Не удалось получить доступ к Remote Service. Вернем null");
        }
    }
}
