package faang.school.godbless.multithreading.witcher;

import java.util.Random;

public record Monster(String name, City nearCity) {

    public int getKillTime() {
        return new Random().nextInt(0,10);
    }
}