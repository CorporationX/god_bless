package faang.school.godbless.nicebutpoor;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Chore implements Runnable{
    private String chore;
    @Override
    public void run() {
        System.out.println("Chore " + Thread.currentThread().getName() + " named " + chore + " is in work");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
