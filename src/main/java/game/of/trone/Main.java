package game.of.trone;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, House> test = new HashMap<>();
        test.put("Старк", new House("Старк","СтаркГерб"));
        test.put("Ланнистер", new House("Ланнистер","ЛаннистерГерб"));
        test.put("Баратеон", new House("Баратеон","БаратеонГерб"));
        String s = "Спирьков";
        House.addFamily(s,test);

        for (Map.Entry<String, House> pair : test.entrySet()){
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }

        House.deleteFamily(s,test);
        House.searchFamily("Старк", test);
        House.allHouse(test);
}
