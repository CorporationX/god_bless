package faang.school.godbless.LRUCache;

import java.util.Calendar;

public class DataStructure {
    public static Data getData(int lastId) {
        return new Data(lastId,  (int) (Math.random() * 10), Calendar.getInstance());
    }
}
