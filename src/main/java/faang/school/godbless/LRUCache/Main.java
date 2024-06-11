package faang.school.godbless.LRUCache;

import java.time.LocalDateTime;
import java.util.*;

public class Main {
    private static Map<Integer, Data> dataObjectsCash = new HashMap<>();
    private static Map<Integer, Data> dataList = new HashMap<>();

    private static final int CACHE_SIZE = 3;

    public static void main(String[] args) {
        Data data1 = new Data(1, "qd");
        Data data2 = new Data(2, "qd");
        Data data3 = new Data(3, "qd");
        Data data4 = new Data(4, "qd");
        addData(data1);
        addData(data2);
        addData(data3);
        addData(data4);

        getData(1);
        getData(2);
        getData(3);
        getData(4);

        info();

    }

    static void addData(Data data) {
        dataList.put(data.getId(), data);
    }

    static Data getData(int dataId) {
        if (dataObjectsCash.containsKey(dataId)) {
            dataObjectsCash.get(dataId).setTimestamp(LocalDateTime.now());
            return dataObjectsCash.get(dataId);
        } else {
            if (dataObjectsCash.size() >= CACHE_SIZE) {
                removeCash();
            }
            Data d = dataList.get(dataId);
            d.setTimestamp(LocalDateTime.now());
            dataObjectsCash.put(d.getId(), d);
            return d;
        }
    }

    static void info() {
        for (Map.Entry<Integer, Data> map : dataObjectsCash.entrySet()) {
            System.out.println(map.getKey() + " - " + map.getValue());
        }
    }

    static void removeCash() {
        LocalDateTime n = LocalDateTime.now();
        int id = 0;
        for (Map.Entry<Integer, Data> map : dataObjectsCash.entrySet()) {
            if (n.isAfter(map.getValue().getTimestamp())) {
                n = map.getValue().getTimestamp();
                id = map.getKey();
            }
        }
        dataObjectsCash.remove(id);
    }
}
