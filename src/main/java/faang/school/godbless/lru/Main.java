package faang.school.godbless.lru;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static final int CACHE_SIZE = 3;

    public static final Map<Integer, Data> CACHE = new HashMap<>();

    public static final List<Data> storage = new ArrayList<>();

    public static void addData(int id, String value) {
        Date now = new Date();

        Data newData = new Data(id, value, now);

        storage.add(newData);
    }

    public static void getData(int id) {
        Data data = CACHE.get(id);

        if (data!=null) {
            data.setTimestamp(new Date());

            checkOnDeprecated();

            System.out.println(data);
            return;
        }


        Data dataStorage = getDataStorage(id);

        if (dataStorage==null) {
            System.out.println("404 : Not found data");
            return;
        }

        CACHE.put(id, dataStorage);
        System.out.println(dataStorage);
    }

    // иммитация обращения в бд)
    public static Data getDataStorage(int id) {

        for (Data d : storage) {
            if (d.getId() == id) {
                return d;
            }
        }

        return null;
    }

    public static void checkOnDeprecated() {
        Date oldDate = new Date();
        oldDate.setTime(1212121212121L);
        int oldID = 0;

        if (CACHE.size()>=CACHE_SIZE) {
            for (Map.Entry<Integer, Data> entry: CACHE.entrySet()) {
                Data curData = entry.getValue();
                if (curData.getTimestamp().before(oldDate)) {
                    oldDate = entry.getValue().getTimestamp();
                    oldID = curData.getId();
                }
            }
            CACHE.remove(oldID);
        }
    }

    public static void сurrentStateCACHE() {
        CACHE.forEach((k, v) -> System.out.println(k + v.toString()));
    }

    public static void main(String[] args) {

        addData(0, "bitcoin");
        addData(1, "lolcoin");
        addData(2, "kekcoin");
        addData(3, "bobr");

        getData(0);
        getData(1);
        getData(2);

        System.out.println();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getData(0);
        getData(2);
        getData(3);

        System.out.println();

        сurrentStateCACHE();


    }
}
