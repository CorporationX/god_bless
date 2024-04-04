package faang.school.godbless.GameOfThrones;

import java.util.HashMap;
import java.util.Map;

public class MainClass {
    Map<String, House> houses = new HashMap<>();
    public static void main(String[] args) {
        MainClass app = new MainClass();

        app.add("Stark", new House("Stark", "1234"));
        app.add("Lannister", new House("Lannister", "3563"));
        app.add("Baratenon", new House("Baratenon", "8395"));

        app.get("Lannister");
        app.delete("Lannister");

        app.getAll();
    }
    public void add(String name, House house){
        houses.put(name, house);
    }
    public void delete(String name){
        houses.remove(name);
    }
    public void get(String name){
        System.out.println( houses.get(name));
    }

    public void getAll(){
        houses.forEach((s, house) -> System.out.println(s + ":" + house.getSigil()));
    }


}
