package faang.school.godbless.BJS2_24206;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private String assignedName;
    private String taskName;

    @Override
    public void run() {
        try {
            System.out.printf("%s начал выполнять задание: %s%n", assignedName, taskName);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.printf("Что-то пошло не так и %s не завершил задание %s%n. Сообщение об ошибке: %s",
                    assignedName, taskName, e.getMessage());
        }
    }
}
