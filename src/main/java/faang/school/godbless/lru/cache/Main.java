package faang.school.godbless.lru.cache;

import java.util.Random;

public class Main {
    public static void main (String[] args) {
        DataStructure ds = new DataStructure();

        for (int i = 0; i < 8; i++) {
            Data data = new Data("data-" + i);
            int dataId = data.getId();

            ds.addDataToDataStructure(data);
            ds.getDataById(dataId);
        }

        ds.getCacheCurrentState();
    }
}
