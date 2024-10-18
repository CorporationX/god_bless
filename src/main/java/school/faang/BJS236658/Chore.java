package school.faang.BJS236658;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        try {
            System.out.println("Поток - " + Thread.currentThread().getName());
            Thread.sleep(2000);
            System.out.println(chore + " Выполнено!");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(chore + " Была прервана!");
        }
    }
}
