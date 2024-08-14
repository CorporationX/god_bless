package lru;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Data> dataByInteger = new HashMap<>();
        Map<Integer, Data> dataCash = new HashMap<>();

        Data.addData(dataByInteger, 0, new Data(0, "Что-то №0", 0));
        Data.searchData(dataByInteger, dataCash, 0);
        dataCash.put(1, new Data(1, "Что-то №1", 4));
        dataCash.put(2, new Data(2, "Что-то №2", 2));
        dataCash.put(3, new Data(3, "Что-то №3", 5));
        dataCash.put(4, new Data(4, "Что-то №4", 8));
        dataCash.put(5, new Data(5, "Что-то №5", 3));
        dataCash.put(6, new Data(6, "Что-то №6", 9));
        dataCash.put(7, new Data(7, "Что-то №7", 2));
        dataCash.put(8, new Data(8, "Что-то №8", 8));
        dataCash.put(9, new Data(9, "Что-то №9", 1));
        dataByInteger.put(10, new Data(10, "Что-то №10", 7));
        dataByInteger.put(11, new Data(11, "Что-то №11", 4));
        Data.searchData(dataByInteger, dataCash, 10);
       // Data.outputMap(dataCash);
        Data.searchData(dataByInteger, dataCash, 2);
       Data.searchData(dataByInteger, dataCash, 11);
        Data.outputMap(dataCash);


    }
}
