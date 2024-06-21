package faang.school.godbless.nicepoor;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Chore implements  Runnable{
    private String chore;
    @Override
    public void run() {
        try {
            String name =Thread.currentThread().getName();
            System.out.println(name);
            Thread.sleep(1000);
            System.out.println("Job is done");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
