package com.map.lrucache;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main implements Runnable {
    private final static int CACHE_SIZE = 3;
    private static Map<Integer, Data> dataMap = new HashMap<>();
    private static LinkedList<Integer> cache = new LinkedList<>();

    public static void main(String[] args) throws InterruptedException {
        addData(new Data(1, 11));
        addData(new Data(2, 12));
        addData(new Data(3, 13));
        addData(new Data(4, 14));


        System.out.println("main start");

        Thread thread = new Thread(new Main());
        thread.start();
        thread.join();

        cache.forEach(System.out::println);
        System.out.println();

        System.out.println(getData(2));
        System.out.println();

        getInfoAboutCache();
        System.out.println();

        cache.forEach(System.out::println);
        System.out.println("main finish");


    }

    // Создан поток для иллюстрации добавления времени в переменную timestamp.
    @Override
    public void run() {
        System.out.println("Thread start");
        for (int i = 1; i < 5; i++) {
            getData(i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void addData(Data data) {
        dataMap.put(data.getId(), data);

    }

    public static Data getData(int id) {
        Data data;
        if (cache.contains(dataMap.get(id).getId())) {
            cache.remove((Object) dataMap.get(id).getId());
        } else if (cache.size() == CACHE_SIZE) {
            cache.removeFirst();
        }
        data = dataMap.get(id);
        setTime(id);
        cache.add(dataMap.get(id).getId());

        return data;
    }

    public static void getInfoAboutCache() {
        dataMap.entrySet().forEach(System.out::println);
    }

    // Метод создает время обращения к объекту в кэш, возвращает строку времени в указанном формате.
    public static void setTime(int id) {
        dataMap.get(id).setTimestamp(LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

}
