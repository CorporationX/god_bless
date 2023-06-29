package faang.school.godbless.threePigs;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PigThread extends Thread {
    private String pigName;
    private int material;

    public static final List<String> MATERIALS = List.of("солома", "палки", "кирпичи");

    @Override
    public void run() {
        System.out.printf("%s взял материал: %s \n", getPigName(), MATERIALS.get(getMaterial()));
        try {
            Thread.sleep(100L);
            System.out.printf("%s вспомнил как строить дом.\n", getPigName());
            Thread.sleep(400L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s построил из материала %s новый дом!\n", getPigName(), MATERIALS.get(getMaterial()));
    }
}
