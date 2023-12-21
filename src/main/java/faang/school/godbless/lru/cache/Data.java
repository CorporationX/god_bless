package faang.school.godbless.lru.cache;

import java.sql.Timestamp;

public class Data {
    private static int globalId = 0;
    private final Timestamp TIMESTAMP;
    private final int ID;
    private final String VALUE;

    public Data (String value) {
        VALUE = value;
        ID = globalId++;
        TIMESTAMP = new Timestamp(System.currentTimeMillis());
    }

    public int getId () {
        return ID;
    }

    public String getValue () {
        return VALUE;
    }
}