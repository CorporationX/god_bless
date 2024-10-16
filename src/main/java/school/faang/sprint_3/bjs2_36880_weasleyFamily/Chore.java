package school.faang.sprint_3.bjs2_36880_weasleyFamily;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        System.out.println("Поток номер: " + Thread.currentThread().getName() + " выполняет задачу " + chore);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Задача '" + chore + "' выполнена!");
    }
}
