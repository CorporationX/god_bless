package got;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<String, House> map = new HashMap<>();
    public static void main(String[] args){
        addHouse(createHouse("Stark","Dog"));
        addHouse(createHouse("Lanister","Lion"));
        addHouse(createHouse("Barateon","Deer"));
        addHouse(createHouse("Balykov","Fish"));
        System.out.println("Все дома:");
        showHouses();
        System.out.println("Мой герб: "+ getHouseSigil("Balykov"));
        deleteHouse("Balykov");
        System.out.println("Дома Вестероса:");
        showHouses();
    }

    static House createHouse(String name, String sigil){
        return new House(name,sigil);
    }

    static void addHouse(House house){
        map.put(house.getName(),house);
    }

    static void deleteHouse(String name){
        map.remove(name);
    }

    static String getHouseSigil (String name){
        return map.get(name).getSigil();
    }
    static void showHouses(){
        for(Map.Entry<String, House> entry: map.entrySet()){
            System.out.println("Название дома: " + entry.getKey() + ". Герб: " + entry.getValue().getSigil());
        }
    }
}
