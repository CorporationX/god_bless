package school.faang.extremelypor.maincode;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " выполняет задачу: " + chore);
            Thread.sleep(1000);
            System.out.println(chore + " выполнена");
        } catch (InterruptedException e) {
            System.out.println("Задача " + chore + "была прервана");
        }
    }
}
