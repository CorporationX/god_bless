package school.faang.task136;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final HashMap<String, House> HOUSES = new HashMap<>();

    public void addNewHouse(House house) {
        HOUSES.put(house.getName(), house);
    }

    public void removeHouse(String houseName) {
        HOUSES.remove(houseName);
    }

    public String getSigil(String houseName) {
        return HOUSES.get(houseName).getSigil();
    }

    public void printAllHouse() {
        for (Map.Entry<String, House> entry : HOUSES.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().getSigil());
        }
    }

    public static void main(String[] args) {
        House lannister = new House("Lannister", "Lion");
        House targaryen = new House("Targaryen", "Dragon");
        House stark = new House("Stark", "Wolf");

        Main main = new Main();

        main.addNewHouse(lannister);
        main.addNewHouse(targaryen);
        main.addNewHouse(stark);

        System.out.println(main.getSigil(lannister.getName()));
        System.out.println(main.getSigil(targaryen.getName()));
        System.out.println(main.getSigil(stark.getName()));
        System.out.println();

        main.printAllHouse();
        System.out.println();

        main.removeHouse(targaryen.getName());

        main.printAllHouse();
        System.out.println();
    }
}
