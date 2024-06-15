package faang.school.godbless.BJS2_8950;

import java.util.HashMap;
import java.util.Map;

public class DataBase {
    private Map<Integer, Data> dataBase = new HashMap<>();

    public void addData(Data data) {
        dataBase.put(data.getId(), data);
    }

    public Data getData(int id) {
        if (!dataBase.containsKey(id)) {
            System.out.println("Такого ключа нет в базе");
            return null;
        }
        return dataBase.get(id);
    }
}
