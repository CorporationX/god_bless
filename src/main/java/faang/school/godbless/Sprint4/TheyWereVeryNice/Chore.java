package faang.school.godbless.Sprint4.TheyWereVeryNice;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @SneakyThrows
    @Override
    public void run() {
        System.out.printf("Поток - %s начал работу\n", Thread.currentThread().getName());
        Thread.sleep(1000);
        System.out.printf("Поток - %s закончил работу\n", Thread.currentThread().getName());
    }
}
