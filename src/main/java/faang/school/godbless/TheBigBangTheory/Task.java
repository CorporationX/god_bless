package faang.school.godbless.TheBigBangTheory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable{
    private String name;
    private String task;
    @Override
    public void run() {
        System.out.println(name + " начал выполнять задание: " + task);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Ошибка! Прерывание задачи " + task);
            // Перевыбрасываем InterruptedException для установки флага прерывания
            Thread.currentThread().interrupt();
        }
    }
}
