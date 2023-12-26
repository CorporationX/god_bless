package faang.school.godbless.multi_paral.task11spacex;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RocketLaunch {
    private String name;
    private long time;

    public void launch() {
        try {
            Thread.sleep(1000);
            System.out.println("Запуск: '" + name + "' Время: " + System.currentTimeMillis() + " ms");
        } catch (InterruptedException e) {
            System.out.println("Запуск прерван");
        }
    }
}
