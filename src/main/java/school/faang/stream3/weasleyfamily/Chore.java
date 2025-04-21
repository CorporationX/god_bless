package school.faang.stream3.weasleyfamily;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class Chore implements Runnable {

    private final String chore;

    @SneakyThrows
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.printf("%s started work on task: %s\n", name, chore);
        long millis = chore.length() * 15L;
        Thread.sleep(millis);
        System.out.printf("%s finished work on task: %s, it took %d of time\n", name, chore, millis);

    }
}
