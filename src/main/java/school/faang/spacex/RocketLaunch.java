package school.faang.spacex;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RocketLaunch {
    private static final int MILLIS = 1000;
    private final String name;
    private final long launchTime;

    public void launch() {
        try {
            Thread.sleep(MILLIS); // симуляция подготовки запуска
            System.out.printf("Ракета \"%s\" запускается!%n", name);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.printf("Запуск ракеты \"%s\" был прерван.%n", name);
        }
    }

}
