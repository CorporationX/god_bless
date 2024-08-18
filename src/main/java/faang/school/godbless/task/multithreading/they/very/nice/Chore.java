package faang.school.godbless.task.multithreading.they.very.nice;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Chore implements Runnable {
    private final String chore;

    @Override
    public void run() {
        System.out.println("Задача '%s' выполняется в потоке: %s"
                .formatted(chore, Thread.currentThread().getName()));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }
}
