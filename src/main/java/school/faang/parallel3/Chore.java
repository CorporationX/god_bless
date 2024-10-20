package school.faang.parallel3;

import lombok.Getter;

@Getter
public class Chore implements Runnable{

    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() +
                    " выполняет задачу: " + getChore());
            Thread.sleep(5000);
            System.out.println("Задача \"" + chore + "\" выполнена.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
