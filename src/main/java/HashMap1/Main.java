package HashMap1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, House> map = new HashMap<>();
        //Старк, Ланнистер, Баратеон
        House stark = new House("Stark", "sigil1");
        House lannister = new House("Lannister", "sigil2");
        House barateon = new House("Barateon", "sigil3");
        put(map,"Stark",stark);
        put(map,"Lannister", lannister);
        put(map, "Barateon", barateon);
        System.out.println(map);
        List<String> list = getAll(map);
        System.out.println(list);
        get(map,"Stark");
        remove(map, "Stark");
        remove(map, "Lannister");
        System.out.println(map);



    }
    public static void put(Map<String, House> map, String name, House house){
        map.put(name,house);
    }
    public static void remove(Map<String, House> map, String name){
        map.remove(name);
    }
    public static void get(Map<String, House> map, String name){
        String sigil = map.get(name).getSigil();
        System.out.println(name + " " + sigil);
    }
    public static List<String> getAll(Map<String, House> map){
        List<String> list = new ArrayList<>();
        for(Map.Entry<String, House> entry : map.entrySet()){
            list.add(entry.getKey()+" " + entry.getValue().getSigil());
        }
        return list;
    }
}
