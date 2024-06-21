package faang.school.godbless.bigbangtheory;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Task implements  Runnable {
    private String name;
    private String task;
    @Override
    public void run() {
        try {
            System.out.println("Пользователь "+name+" начал делать задание "+task);
            Thread.sleep(1000);
            System.out.println("Пользователь "+name+" завершил задание "+task);

        } catch (InterruptedException e) {
            System.out.println("Возникла ошибка");
            throw new RuntimeException(e);
        }
    }
}
