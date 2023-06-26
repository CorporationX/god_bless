package faang.school.godbless.kxnvg.extremelypoor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {

    private String chore;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " начал выполнение задачи: " + chore);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Задача " + chore + " была прервана");
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " выполнил задачу");
    }
}
