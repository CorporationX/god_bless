package faang.school.godbless.BJS212277;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class Chore implements Runnable {

    private String chore;

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(String.format("Поток %s начал выполнение задачи %s ", Thread.currentThread().getName(), chore));
        Thread.sleep(5000);
        System.out.println(String.format("Поток %s закончил выполнение задачи %s ", Thread.currentThread().getName(), chore));
    }
}
