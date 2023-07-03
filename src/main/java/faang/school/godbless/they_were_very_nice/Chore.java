package faang.school.godbless.they_were_very_nice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Chore implements Runnable{
    String chore;
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " начал выполнять задачу "+ getChore());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " выполнил задачу "+ getChore());
    }
}
