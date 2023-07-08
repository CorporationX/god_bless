package faang.school.godbless.parallel.its_normal_game;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Random;

@Getter
@AllArgsConstructor
public class PigThread extends Thread {
    private String pigName;
    private int material;
    private final List<String> homeMaterials = List.of("солому", "палки", "кирпичи");

    @Override
    public void run() {
        String pigName = this.pigName;
        String material = homeMaterials.get(this.material);
        System.out.printf("%s начинает постройку дома, используя %s....%n", pigName, material);
        try {
            Thread.sleep((new Random().nextInt(0,5))*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s построил свой домик.%n", pigName);
    }
}

