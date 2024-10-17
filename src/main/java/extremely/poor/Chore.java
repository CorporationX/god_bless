package extremely.poor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " в потоке выполняется " + chore);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Произошла ошибка " + e.getMessage());
        }
    }
}
