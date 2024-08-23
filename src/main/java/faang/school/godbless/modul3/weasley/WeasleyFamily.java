package faang.school.godbless.modul3.weasley;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        String[] chores = {"Dishwashing", "Vacuuming", "Washing", "Nothing"};

        Arrays.stream(chores)
                .map(Chore::new)
                .forEach(service::execute);

        service.shutdown();
    }
}
