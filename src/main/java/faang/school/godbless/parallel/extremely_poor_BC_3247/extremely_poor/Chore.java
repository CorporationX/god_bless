package faang.school.godbless.parallel.extremely_poor_BC_3247.extremely_poor;

import lombok.Data;

import java.util.Random;

@Data
public class Chore implements Runnable{
    public String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        String chore = this.chore;
        String threadName = Thread.currentThread().getName();
        System.out.printf("Задача %s начинает выполнение в потоке %s\n", chore, threadName);
        try {
            Thread.sleep((new Random().nextInt(0,5))*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Задача %s выполнена \n", chore);
     }
}
