package faang.school.godbless.the.big.bang.theory;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(getName() + " начал выполнять " + getTask());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
        System.out.println(getName() + " закончил выполнять " + getTask());
    }
}
