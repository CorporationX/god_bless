package school.faang.TheyWereNice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Chore implements Runnable{
    private String chore;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": started chore: " + chore);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new IllegalStateException("Something went wrong: ", e);
        }
        System.out.println(Thread.currentThread().getName() + ": finished chore: " + chore);
    }
}
