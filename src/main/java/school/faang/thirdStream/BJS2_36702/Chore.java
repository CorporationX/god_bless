package school.faang.thirdStream.BJS2_36702;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        try {
            System.out.println("Выполнение задачи '" + chore + "' потоком " + Thread.currentThread().getName());
            Thread.sleep(2500);
            System.out.println("Задание '" + chore + "' выполнено!");
        } catch (InterruptedException e) {
            System.out.println("Выполнение задачи '" + chore + "' было превано");
        }
    }
}
