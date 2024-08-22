package ru.kraiush.BJS2_20242;


import lombok.*;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.LinkedList;

public class App_LRUCache {

    private static final int CACHE_SIZE = 5;

    HashMap<Integer, Data> data = new HashMap<>();

    LinkedList<Integer> order = new LinkedList<>();

    int capacity;

    App_LRUCache(int capacity) {
        this.capacity = capacity;
    }

    void put(int key, Data val) {

        Data d = data.get(key);

        if(d != null) {
            d.setTime(new Timestamp(System.currentTimeMillis()));
            data.put(key, d);
            return;
        }
        if (order.size() >= capacity) {
            int keyRemoved = order.removeLast();
            data.remove(keyRemoved);
        }
        order.addFirst(key);
        data.put(key, val);
        System.out.println("order: " + order);
    }

    Data get(int key) {
        Data res = data.get(key);
        if(res != null) {
            order.remove((Object) key);
            order.addFirst(key);
        }else {
            return null;
        }
        return res;
    }

    public void display() {
        data.forEach((K,V) -> System.out.println("key: "+ K + " value: " + V));
    }

    public static void main(String[] args) {

        App_LRUCache cache = new App_LRUCache(CACHE_SIZE );

        for(int i=0; i <= 20; i++) {
            int key = figureOut();

            Data d = new Data(key, "value-"+ key, new Timestamp(System.currentTimeMillis()));
            System.out.println("new data: " + d);
//            cache.display();

            cache.put(key, d);
        }
        System.out.println("\n Final Cache:");
        cache.display();
    }
    private static int figureOut() {
        double power = 1;
        for (int j = 0; j < 4; j++) {
            power *= Math.random();
        }
        return (int) (power * 100); // Keys up to 9999 but more common in lower numbers.
    }
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
class Data {
    int id;
    String value;
    Timestamp time;
}

