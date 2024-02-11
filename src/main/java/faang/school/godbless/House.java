package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class House {

    private String name;
    private String sigil;

    public House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }

    @Override
    public String toString() {
        return  name + " " + sigil;
    }

    private static void addHouse(HashMap<String, House> housesMap, String name, String sigil) {
        //добавление
        if(housesMap.containsKey(name)){
            housesMap.put(name, new House(name, sigil));
        }
        System.out.println("House added: " + name);
    }

    private static void removeHouse(HashMap<String, House> housesMap, String name, String sigil) {
        //удаление
        if (housesMap.containsKey(name)) {
            housesMap.remove("Starks");
            System.out.println("House removed: " + name);
        } else {
            System.out.println("House not found");
        }
    }

    private static void getHouse(HashMap<String, House> housesMap, String name, String sigil) {
        //get
        if (housesMap.containsKey(name)) {
            House getHouse = housesMap.get("Lanister");
            System.out.println("House name received:  " + getHouse);
        } else {
            System.out.println("House" + name + "not found:");
        }
    }

    private static void iterateHouse(HashMap<String, House> housesMap, String name, String sigil) {
        //printAll
        for (Map.Entry<String, House> entry : housesMap.entrySet()) {
            System.out.println("Name: " + entry.getKey() + "\t" + " Sigil: " + entry.getValue());
        }
    }
}
