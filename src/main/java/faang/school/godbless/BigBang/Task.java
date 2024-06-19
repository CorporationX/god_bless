package faang.school.godbless.BigBang;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Task implements Runnable{
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println("Выполняет " + task + "он" + name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Задание " + task + " Прервано");
            return; // выход из метода run после прерывания
        }
        System.out.println("Задание " + task + " Было выполненно" + name);
    }



}
