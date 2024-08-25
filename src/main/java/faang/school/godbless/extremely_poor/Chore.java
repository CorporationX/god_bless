package faang.school.godbless.extremely_poor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {

    private String chore;

    @Override
    public void run() {
        System.out.println("Поток " + Thread.currentThread().getName() + " начал выполнять задачу - " + chore);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

        System.out.println("Поток " + Thread.currentThread().getName() + " выполнил задачу - " + chore);
    }
}
