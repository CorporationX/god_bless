package faang.school.godbless.Task_LRU_Cache;

import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.HashMap;

@NoArgsConstructor
public class LRU {

    protected static final int MAX = 4;
    protected Map<Integer, Data> cache = new HashMap<>();
    protected int first;
    protected int last;

    public void addToLRU(int x, Data data) {
        if (cache.size() == 0) {
            data.timestamp = new Time(x, x);
            first = x;
            last = x;
            cache.put(x, data);
        } else if (cache.size() < MAX) {
            data.timestamp = new Time(first, x);
            cache.compute(first, (key, value) -> value).timestamp.next = x;
            first = x;
            cache.put(x, data);
        } else {
            int newLast = cache.get(last).timestamp.next;
            cache.compute(newLast, (key, value) -> value).timestamp.prev = newLast;
            cache.compute(first, (key, value) -> value).timestamp.next = x;
            int newFirst = first;
            first = x;
            cache.remove(last);
            last = newLast;
            data.timestamp = new Time(newFirst, x);
            cache.put(x, data);
        }
    }

    public void getFromLRU(int x) {
        if (x == last) {
            int afterLast = cache.get(x).timestamp.next;
            cache.compute(afterLast, (key, value) -> value).timestamp.prev = afterLast;
            cache.compute(x, (key, value) -> value).timestamp.prev = first;
            cache.compute(x, (key, value) -> value).timestamp.next = x;
            cache.compute(first, (key, value) -> value).timestamp.next = x;
            System.out.println(cache.get(x));
            first = x;
            last = afterLast;
        } else if (x == last) {
            System.out.println(cache.get(x));
        } else {
            int lastPrev = cache.get(x).timestamp.prev;
            int lastNext = cache.get(x).timestamp.next;
            cache.compute(lastPrev, (key, value) -> value).timestamp.next = lastNext;
            cache.compute(lastNext, (key, value) -> value).timestamp.prev = lastPrev;
            cache.compute(x, (key, value) -> value).timestamp.prev = first;
            cache.compute(x, (key, value) -> value).timestamp.next = x;
            cache.compute(first, (key, value) -> value).timestamp.next = x;
            System.out.println(cache.get(x));
            first = x;
        }
    }

    public void showLRU() {
        for (Map.Entry<Integer, Data> entry : cache.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("first_key " + first);
        System.out.println("last_key " + last);
    }

    public void timeIteration() {
        System.out.println();
        int iterator = last;
        boolean needIteration = true;
        while (needIteration) {
            System.out.println(iterator + ": " + cache.get(iterator));
            iterator = cache.get(iterator).timestamp.next;
            if (iterator == first) {
                System.out.println(iterator + ": " + cache.get(iterator));
                needIteration = false;
            }
        }
        System.out.println();
    }

    protected static class Data {
        int id;
        int value;
        Time timestamp;

        Data(int id, int value, Time timestamp) {
            this.id = id;
            this.value = value;
            this.timestamp = timestamp;
        }

        @Override
        public String toString() {
            return "(" + id + ", " + value + ", " + timestamp + ")";
        }
    }

    protected static class Time {
        int prev;
        int next;

        Time(int prev, int next) {
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return "(" + prev + ", " + next + ")";
        }
    }

}