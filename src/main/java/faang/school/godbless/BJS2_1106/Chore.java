package faang.school.godbless.BJS2_1106;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class Chore implements Runnable{
    private String chore;


    @SneakyThrows
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" in process");
        Thread.sleep(4000);
        System.out.println(Thread.currentThread().getName()+" is completed");
    }
}
