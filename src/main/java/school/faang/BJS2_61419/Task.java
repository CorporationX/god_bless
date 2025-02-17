package school.faang.BJS2_61419;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Task implements Runnable {
    private final String name;
    private final String task;

    @Override
    public void run() {
        try {
            System.out.println(name + " начал выполнение задачи: " + task);
            Thread.sleep(1000); // Задержка в 1 секунду
            System.out.println(name + " успешно выполнил задачу: " + task);
        } catch (InterruptedException e) {
            System.out.println(name + " был прерван во время выполнения задачи: " + task);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}