package BigBang;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task implements Runnable{
    private String name;
    private String task;
    @Override
    public void run() {
        System.out.printf("%s is starting %s\n", name, task);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s is finished %s\n", name, task);
    }
}
