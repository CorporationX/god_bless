package lru;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Setter
@Getter

public class Data {
    public static final int CASH_SIZE = 10;
    private int id;
    private String value;
    private int timestamp;

    public Data(int id, String value, int timestamp) {
        this.id = id;
        this.value = value;
        this.timestamp = (int) System.currentTimeMillis();
    }


    public void updateTimestamp() {
        this.timestamp = (int) System.currentTimeMillis(); // Обновляем время обращения
    }

    public static void addData(Map<Integer, Data> dataByInteger, int id, Data data) {
        if (!dataByInteger.containsKey(id)) {
            dataByInteger.put(id, data);
        } else {
            System.out.println("ID уже принадлежит другому объекту");
        }
    }

    public static void searchData(Map<Integer, Data> dataByInteger, Map<Integer, Data> dataCash, int id) {
        if (dataCash.containsKey(id)) {
            System.out.println(dataCash.get(id));
            dataCash.get(id).setTimestamp(+1);
        } else {
            Data timeData = dataByInteger.get(id);
            dataCash.put(id, timeData);
            System.out.println(dataCash.get(id));
            dataCash.get(id).setTimestamp(+1);
        }
    }

    public static void updateTimestamp( Map<Integer, Data> dataCash) {
        if (dataCash.size() > CASH_SIZE) {
            List<Map<Integer, Data>> mapList = new ArrayList<>((Collection) dataCash);

            Collections.sort(mapList, new Comparator<Map<Integer, Data>>() {
                @Override
                public int compare(Map<Integer, Data> o1, Map<Integer, Data> o2) {
                    return compare(o1,o2);
                }
            });

            Map<Integer, Data> sortedMap = new HashMap<>((Map) mapList);
            for (int i = 0; i < sortedMap.size(); i++) {
                Data data1 = sortedMap.get(i);
                for (int j = 0; j < dataCash.size(); j++) {
                    Data data2 = dataCash.get(j);
                    if(data1.equals(data2)) {
                        dataCash.remove(dataCash.get(j));
                        break;
                    }

                }

            }
        }
    }
}
