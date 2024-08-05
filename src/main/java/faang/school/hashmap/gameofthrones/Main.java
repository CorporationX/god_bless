package faang.school.hashmap.gameofthrones;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static HashMap <String, House> mapHouse = new HashMap<>();
    public static void main(String[] args) {

        mapHouse.put("Stark",new House("Stark","Direwolf"));
        mapHouse.put("Lannister",new House("Lannister","Leon"));
        mapHouse.put("Baratheons",new House("Baratheons","Black deer"));
        mapHouse.put("Martell",new House("Martell","Solar spear"));
        mapHouse.put("Arenas",new House("Arenas","White falcon and the moon"));

        outputInfoSigil("Stark");
        deleteHouse("Stark");
        addNewHouse(new House("Javar","Java"));
        outputAllHouseAndSigil();

    }
    public static void addNewHouse (House house){
        mapHouse.put(house.getNameHouse(), house);
    }
    public static void deleteHouse (String nameHouse){
        mapHouse.remove(nameHouse);
    }
    public static void outputInfoSigil (String nameHouse){
        if (mapHouse.containsKey(nameHouse)){
            System.out.println(mapHouse.get(nameHouse).getSigilHouse());
        }
    }
    public static void outputAllHouseAndSigil (){
        for (Map.Entry house: mapHouse.entrySet()){
            System.out.println(house);
        }
    }
}
