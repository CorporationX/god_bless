package faang.school.godbless.BJS2_24141;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class Chore implements Runnable {
    private final String chore;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " начинает выполнение задачи: " + chore);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Задача была прервана: " + chore);
        }
        System.out.println(Thread.currentThread().getName() + " завершил выполнение задачи: " + chore);
    }
}