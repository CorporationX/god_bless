package faang.school.godbless.BJS2_8924;


import lombok.RequiredArgsConstructor;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
// переименованный Main
public class LRUCache {
    private final Integer CACHE_SIZE;
    private final Map<Integer, Data> cache = new HashMap<>();
    // в голове хранится ключ самых недавно использованных данных
    private Data head;
    // в хвосте хранится ключ самых давних использованных данных
    private Data tail;

    public String get(Integer key) {
        if (cache.containsKey(key)) {
            // если есть обновляем кэш и выдаем значение
            moveToHead(cache.get(key));

            return cache.get(key).getValue();
        }
        // иначе возвращаем пустую строку
        return "";
    }

    public void put(Integer key, String value) {
        // Создаем класс Data и помещаем в него данные
        Data data = new Data(key, value);

        if (cache.containsKey(key)) {
            // если в кэше есть значение то просто обновляем его
            cache.put(key, data);
            moveToHead(data);
        } else {
            // если нету такого в кэше, добаввляем
            if (cache.size() == CACHE_SIZE) {
                // если переполнен кэш - удалим хвост
                cache.remove(key);
                removeTail();

                // добавляем данные в кэш и в голову
                cache.put(key, data);
                addToHead(data);
            }
        }
    }

    // при обращении или внесении данных в кэш обновляем его
    private void moveToHead(Data data) {
        // если голова то ничего двигать не надо
        if (data != head) {
            // если хвот то логика другая
            if (data != tail) {
                head.prev = data;

                data.prev.next = data.next;
                data.next.prev = data.prev;

                data.prev = null;
                data.next = head;
            } else {
                data.prev.next = null;
                data.prev = null;
                data.next = head;
                head.prev = data;
            }

            head = data;
        }
    }

    private void addToHead(Data data) {
        // если не пустой список
        if (head != tail) {
            if (tail == null) {
                // если один эл-мент в списке
                tail = head;
                tail.prev = data;
                data.next = tail;
                data.prev = null;
            } else {
                // если не один элмент в списке
                head.prev = data;
                data.prev = null;
                data.next = head;
                head = data;
            }
        } else {
            // если список пустой
            head = data;
        }
    }

    // при обращении на вставку в переполненный кэш удаляет самое давно использзованное значение
    // гарантия непустого кэша
    private void removeTail() {
        // делаем предыдущий элемент хвостом
        tail = tail.prev;

        // разрываем ссылки с предыдущим хвостом
        tail.next.prev = null;
        tail.next = null;
    }
}
