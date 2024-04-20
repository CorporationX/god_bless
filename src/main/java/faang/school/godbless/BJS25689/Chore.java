package faang.school.godbless.BJS25689;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        System.out.println("Выполняется задача '" + chore + "' в потоке: " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Задача '" + chore + "' выполнена.");
    }
}