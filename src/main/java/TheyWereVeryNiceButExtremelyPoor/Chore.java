package TheyWereVeryNiceButExtremelyPoor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        System.out.println("Исполнителем " + Thread.currentThread().getName() +
                " задача " + chore + " взята в работу.");
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
        System.out.println("Исполнитель " + Thread.currentThread().getName() +
                " выполнил задачу " + chore + "!");
    }
}
