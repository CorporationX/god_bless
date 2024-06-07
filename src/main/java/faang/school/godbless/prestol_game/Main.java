package faang.school.godbless.prestol_game;

import java.util.HashMap;
import java.util.Map;

public class Main {


    public static void main(String[] args) {

        Map<String, House> vesterosHouses = new HashMap<>();
        House stark = new House("Stark","Stark Sigil");
        House lannister = new House("Lannister", "Lannister Sigil");
        House barateon = new House("Barateon", "Barateon Sigil");

        vesterosHouses.put(stark.getName(), stark);
        vesterosHouses.put(lannister.getName(), lannister);
        vesterosHouses.put(barateon.getName(), barateon);

        House.showAllHousesData(vesterosHouses);

        House.addHouse(new House("New house", "New house sigil"), vesterosHouses);

        House.showAllHousesData(vesterosHouses);

    }
}
