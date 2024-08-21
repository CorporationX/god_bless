package faang.school.godbless.weasley;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String name;

    @Override
    public void run() {
        var threadName = Thread.currentThread().getName();
        System.out.printf("%s will be done by %s\n", name, threadName);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.printf("%s was interrapted\n", threadName);
            return;
        }
        System.out.printf("%s is done\n", name);
    }
}
