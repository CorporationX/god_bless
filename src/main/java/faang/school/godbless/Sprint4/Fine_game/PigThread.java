package faang.school.godbless.Sprint4.Fine_game;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class PigThread extends Thread {
    private String pigName;
    private int material;

    @Override
    public void run() {
        System.out.printf("Поросенок по имени - %s начал строить дом из матриала - %d\n время - %s\n", pigName, material, new Date());
        try {
            Thread.sleep(material * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Поросенок по имени - %s закончил\n время - %s\n", pigName, new Date());
    }
}
