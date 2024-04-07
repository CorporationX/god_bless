package faang.school.godbless.gameOfThrones;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, House> map = new HashMap<>();

    public static void main(String[] args) {
        House stark = new House("Stark", "Wolf");
        House lanister = new House("Lanister", "Lion");
        House barateon = new House("Barateon", "Deer");
    }

    public static void addHouse(String name, House house){
        map.put(name, house);
    }
    private static void removeHouse(String name){
        map.remove(name);
    }
    private static String getHouseSigil(String name){
        return map.get(name).getSigil();
    }
    private static void getAllHouseInfo(){
        for(Map.Entry<String, House> entry : map.entrySet()){
            System.out.println("House of "+entry.getKey() +" the sigil is "+entry.getValue().getSigil());
        }
    }
}


