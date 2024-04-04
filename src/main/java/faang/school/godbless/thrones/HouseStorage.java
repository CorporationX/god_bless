package faang.school.godbless.thrones;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HouseStorage {
    private HashMap<String, House> storage = new HashMap<>();

    //добавление нового дома;
    public void addHouse(String name, String sigil) {
        storage.put(name, new House(name, sigil));
    }

    //удаление дома по его названию;
    public void deleteByName(String name) {
        if (storage.containsKey(name)) {
            storage.remove(name);
        } else {
            throw new IllegalArgumentException("Такого дома не существует");
        }
    }

    //поиск дома и вывод информации о гербе дома по его названию;
    public void findHouseByName(String name) {
        if (storage.containsKey(name)) {
            System.out.println(storage.get(name));
        } else {
            throw new IllegalArgumentException("Такого дома не существует");
        }
    }

    //вывод списка всех домов и их гербов.
    public void displayAll() {
        Set<Map.Entry<String, House>> houses = storage.entrySet();
        for (Map.Entry<String, House> house : houses) {
            System.out.println(house.getValue());
        }
    }
}
