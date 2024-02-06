package faang.school.godbless.game_of_thrones;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, House> houses = new HashMap<>();

    public static void main(String[] args) {
        addHome("Cтарк", "RUS");
        addHome("Ланнистер", "USA");
        addHome("Баратеон", "CHINA");
        addHome("Тёплые ветра", "Вайтран");

        showHouses();
        deleteHome("Cтарк");

        findSigil("Тёплые ветраа");
        showHouses();
        findSigil("Тёплые ветра");

    }

    private static void addHome(String name, String sigil) {
        houses.put(name, new House(name, sigil));
    }

    private static void deleteHome(String name) {
        houses.remove(name);
    }

    private static void findSigil(String name){
        House house = houses.get(name);
        if(house != null){
            System.out.println(house.getSigil());
        } else {
            System.out.println("Такого дома нету");
        }
    }

    private static void showHouses(){
        for(Map.Entry<String, House> entry : houses.entrySet()){
            System.out.println(entry.getValue().toString());
        }
    }
}
