package faang.school.godbless.gameofthrones;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class Main {
    private final Map<String, House> housesOfWesteros;

    public void addHouse(House house) {
        String nameOfHouse = house.getName();

        housesOfWesteros.put(nameOfHouse, house);
    }

    public House deleteHouseByName(String name) {
        return housesOfWesteros.remove(name);
    }

    public String findHouseByName(String name) {
        House house = housesOfWesteros.get(name);
        if (house != null) {
            return house.getSigil();
        }
        return String.format("There is no house with the name: %s.", name);
    }

    public String printAllHousesNamesAndSigil() {
        StringBuilder output = new StringBuilder();
        for (Map.Entry<String, House> entry : housesOfWesteros.entrySet()) {
            output.append(String.format("House - %s, Sigil - %s;\n", entry.getKey(), entry.getValue().getSigil()));
        }
        return output.toString();
    }

    public static void main(String[] args) {
        House stark = House.builder()
                .name("Stark")
                .sigil("Direwolf")
                .build();
        House lannistar = House.builder()
                .name("Lannister")
                .sigil("Lion")
                .build();
        House baratheon = House.builder()
                .name("Baratheon")
                .sigil("Stag")
                .build();

        Main myMain = new Main(new HashMap<>());
        myMain.addHouse(stark);
        myMain.addHouse(lannistar);
        myMain.addHouse(baratheon);

        System.out.println(myMain.findHouseByName("Stark"));
        System.out.println(myMain.findHouseByName("Lannister"));
        System.out.println(myMain.findHouseByName("Baratheon"));
        System.out.println(myMain.printAllHousesNamesAndSigil());
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------");
        myMain.deleteHouseByName("Stark");
        System.out.println(myMain.printAllHousesNamesAndSigil());
        System.out.println(myMain.findHouseByName("Stark"));


    }
}
