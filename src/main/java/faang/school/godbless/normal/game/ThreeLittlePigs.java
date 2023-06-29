package faang.school.godbless.normal.game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ThreeLittlePigs {
    public static void main(String[] args) {

        Map<Integer, String> materialID = new HashMap<>();
        materialID.put(1, "солома");
        materialID.put(2, "палки");
        materialID.put(3, "кирпичи");

        List<PigThread> pigs = List.of(new Pig1Thread(materialID), new Pig2Thread(materialID), new Pig3Thread(materialID));
        pigs.stream().forEach(t -> t.start());

        pigs.stream().forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("Игра завершена!");
    }
}
