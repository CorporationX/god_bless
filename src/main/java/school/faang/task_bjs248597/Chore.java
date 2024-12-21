package school.faang.task_bjs248597;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Chore implements Runnable {
    private final String chore;

    public void run() {
        System.out.println("Поток " + Thread.currentThread().getName() + " выполняет работу: " + chore);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Ошибка с потоками");
        }
    }
}
