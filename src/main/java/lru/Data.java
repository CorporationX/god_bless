package lru;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Setter
@Getter
@ToString
public class Data implements Comparable<Data>{
    public static final int CASH_SIZE = 10;
    private int id;
    private String value;
    private int timestamp;

    public Data(int id, String value, int timestamp) {
        this.id = id;
        this.value = value;
        this.timestamp = timestamp;
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
            int i = dataCash.get(id).timestamp;
            i++;
            dataCash.get(id).setTimestamp(i);
            System.out.println(dataCash.get(id));
        } else {
            Data timeData = dataByInteger.get(id);
            dataCash.put(id, timeData);
            Data.updateTimestamp(dataCash);
            int i = dataCash.get(id).timestamp;
            i++;
            dataCash.get(id).setTimestamp(i);
            System.out.println(dataCash.get(id));
        }
    }

    public static void updateTimestamp(Map<Integer, Data> dataCash) {
        if (dataCash.size() > CASH_SIZE) {
          List<Data> dataList = new ArrayList<>(dataCash.values());
          Collections.sort(dataList);

            boolean found = false;
            for (int i = 0; i < dataList.size() && !found; i++) {
                Data data1 = dataList.get(i);
                for (int j = 0; j < dataCash.size(); j++) {
                    Data data2 = dataCash.get(j);

                    if(data1.equals(data2)) {
                        dataCash.remove(dataCash.get(j).id);
                        found = true;
                        break;
                    }
                }

            }

        }
    }

    public static void outputMap(Map<Integer, Data> dataCash) {
        for(Map.Entry<Integer, Data> pair : dataCash.entrySet()) {
            System.out.println(pair.getKey() + ": " + pair.getValue());
        }
    }

    @Override
    public int compareTo(Data data) {
        return (int) (this.timestamp - data.getTimestamp());
    }
}
