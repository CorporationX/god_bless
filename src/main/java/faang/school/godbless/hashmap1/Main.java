package faang.school.godbless.hashmap1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<String, House> houses = new HashMap<>();

    public static void main(String[] args) {
        addHouse("����������", "������� ��������� ������ �� ������ ����");
        addHouse("������", "������� ����� �������� �� ������-����� ����");
        addHouse("����������", "������� ��� �� ������� ����");
        displayAllHouses();
        findHouse("������");
        deleteHouse("������");
        findHouse("������");
        displayAllHouses();
    }

    public static void addHouse(String name, String sigil) {
        houses.put(name, new House(name, sigil));
    }

    public static void deleteHouse(String name) {
        houses.remove(name);
    }

    public static void findHouse(String name) {
        if (houses.containsKey(name)) {
            System.out.println(houses.get(name).sigil());
        } else {
            System.out.println("���� � ����� ��������� �� ����������");
        }
    }

    public static void displayAllHouses() {
        for (Map.Entry<String, House> entry : houses.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().sigil());
        }
    }
}
