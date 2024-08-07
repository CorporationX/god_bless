package faang.school.godbless.BJS2_20192;

import java.util.*;

public class Main {
    private static final int CACHE_SIZE = 4;
    private static final Map<Integer, Data> DATAS = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        Data data1 = new Data(1, 11, new Date());
        Data data2 = new Data(2, 22, new Date());
        Data data3 = new Data(3, 33, new Date());
        Data data4 = new Data(4, 44, new Date());
        Thread.sleep(2000);
        Data data5 = new Data(5, 55, new Date());

        addData(data1);
        addData(data2);
        addData(data3);
        addData(data4);
        addData(data5);
        System.out.println(DATAS);
        Thread.sleep(2000);
        System.out.println(getData(8));
        printCache();
    }

    public static void addData(Data data){
        controlCache();
        DATAS.put(data.getId(), data);
    }

    public static Data getData(Integer id) throws InterruptedException {
        Data data = DATAS.get(id);
        if(data != null){
           data.setTimestamp(new Date());
           return data;
        }
        controlCache();
        data = new Data(id, 666, new Date());
        DATAS.put(id, data);
        return data;
    }

    public static void printCache(){
        DATAS.forEach((id, data) -> System.out.printf("ID: %s, data: %s%n", id, data));
    }

    public static void controlCache(){
        if(DATAS.size() == CACHE_SIZE){
            DATAS.remove(DATAS.values().stream().min(Comparator.comparing(Data::getTimestamp)).get().getId());
        }
    }
}
