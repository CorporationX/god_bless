package faang.school.godbless.prestol_game;

import java.util.HashMap;

public class Main {


    public static void main(String[] args) {

        HashMap<String, House> vesterosHouses = new HashMap<>();//хранение информации о домах

        House stark = new House("Stark","Stark Sigil");
        House lannister = new House("Lannister", "Lannister Sigil");
        House barateon = new House("Barateon", "Barateon Sigil");

        //помещение домов в хранилище
        vesterosHouses.put(stark.getName(), stark);
        vesterosHouses.put(lannister.getName(), lannister);
        vesterosHouses.put(barateon.getName(), barateon);

        House.showAllHousesData(vesterosHouses);
        System.out.println();

        House.addHouse(new House("New house", "New house sigil"), vesterosHouses);
        House.showAllHousesData(vesterosHouses);
        System.out.println();

        House.deleteHouseByHisName("Stark", vesterosHouses);
        House.showAllHousesData(vesterosHouses);
        System.out.println();

        House.getHouseInformationByHisName("Lannister", vesterosHouses);
        System.out.println();
    }
}
