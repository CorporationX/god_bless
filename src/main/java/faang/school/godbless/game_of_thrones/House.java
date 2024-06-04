package faang.school.godbless.game_of_thrones;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class House {
    private String name;
    private String sigil;


    public static void addNewHouses(Map<String, House> houseMap, House ...houses){
        for(House house : houses){
            houseMap.put(house.getName(), house);
        }
    }

    public static void deleteHousesByName(Map<String, House> houseMap, String ...names){
        for(String name : names){
            houseMap.remove(name);
        }
    }

    public static House getHouseByName(Map<String, House> houseMap, String name){
        return houseMap.get(name);
    }

    public static void showSigilsByName(Map<String, House> houseMap, String ...names){
        for(String name : names){
            System.out.println(houseMap.get(name).getSigil());
        }
    }

    public static void showAllHouses(Map<String, House> houseMap){
        for(Map.Entry<String, House> house : houseMap.entrySet()){
            System.out.println(house);
        }
    }
}
