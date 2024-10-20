package school.faang.bjs2_36844;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        WeasleyFamily weasleyFamily = new WeasleyFamily();
        String[] chores = weasleyFamily.getChores();
        ExecutorService executorService = Executors.newCachedThreadPool();

        Arrays.stream(chores)
                .map(Chore::new)
                .forEach(executorService::execute);

        executorService.shutdown();
    }
}
