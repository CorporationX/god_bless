package school.faang.bjs273012;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {

    private String chore;

    @Override
    public void run() {
        String thread = Thread.currentThread().getName();
        System.out.println(thread + " начинает выполнять " + chore);
        try {
            Thread.sleep(1000);
            System.out.println(thread + " закончил выполнять " + chore);
        } catch (InterruptedException e) {
            System.out.println("Задача не выполнена");
        }
    }
}
