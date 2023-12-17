package faang.school.godbless.lru.cache;

import java.util.Random;

public class Main {
    public static void main (String[] args) {
        DataStructure ds = new DataStructure();

        for (int i = 0; i < 8; i++) {
            int id = new Random().nextInt(Integer.MAX_VALUE);
            Data data = new Data(id, "data-" + i);

            ds.addDataToDataStructure(data);
            ds.getDataById(id);
        }

        ds.getCacheCurrentState();
    }
}
