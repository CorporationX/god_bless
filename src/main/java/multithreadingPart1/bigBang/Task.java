package multithreadingPart1.bigBang;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task implements Runnable{
    private String name;
    private String task;

    @Override
    public void run(){
        System.out.println(name + " начал делать " + task);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Задача прервана");
        }
    }

}
