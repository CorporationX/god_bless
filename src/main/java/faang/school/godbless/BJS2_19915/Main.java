package faang.school.godbless.BJS2_19915;

import java.util.HashMap;

public class Main {
    public HashMap<String, House> housesOfWesteros = new HashMap<>();
    {
        housesOfWesteros.put("Baratheon", new House("Baratheon",
                "       /\\ \n" +
                        "      /  \\ \n" +
                        "     /    \\ \n" +
                        "    /______\\ \n" +
                        "    \\      / \n" +
                        "     \\    / \n" +
                        "      \\  / \n" +
                        "       \\/ \n" +
                        "       || \n" +
                        "       || \n" +
                        "       || \n")); // типо олень

        housesOfWesteros.put("Stark", new House("Stark",
                "         __     \n" +
                        "      /     \\ \n" +
                        "     |  o  o  | \n" +
                        "     |   >   | \n" +
                        "      \\_____/ \n" +
                        "       /   \\ \n" +
                        "      /     \\ \n")); // лютоволк с алиэкспресс

        housesOfWesteros.put("Lannister", new House("Lannister",
                "     /\\____/\\ \n" +
                        "    /        \\ \n" +
                        "   |  *  *   | \n" +
                        "   |    *    | \n" +
                        "    \\______ / \n" +
                        "      |    | \n" +
                        "      |____| \n")); // ну кошки это по сути львы после эволюции
    }


    public void addNewHouse(String name, House house) {
        housesOfWesteros.put(name, house);
    }

    public void removeHouseByName(String name) {
        housesOfWesteros.remove(name);
    }

    public void printHouseByName(String name) {
        System.out.println(housesOfWesteros.get(name));
    }

    public void printAllHouses() {
        for(var entry : housesOfWesteros.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
