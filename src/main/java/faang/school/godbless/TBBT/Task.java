package faang.school.godbless.TBBT;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Task implements Runnable {
    String name;
    String task;

    public void run(){
        System.out.println(name + "взял задание "+ task + " в работу!" + " в потоке " + Thread.currentThread().getName());
        try {
            Thread.sleep(4000L);
            System.out.println(name + " все еще выполняет задание: " + task + " в потоке " + Thread.currentThread().getName());
            Thread.sleep(1000L);
            System.out.println(name + " выполнил задание: " + task + " в потоке " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            System.out.println("Задание не выполнено!!!");
        }
    }
}
