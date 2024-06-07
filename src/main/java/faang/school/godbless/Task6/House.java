package faang.school.godbless.Task6;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Map;

@AllArgsConstructor
@Getter
@ToString

class House {

    private String name;
    private String sigil;


    public void addToMap(Map<String, House> houses) {
        houses.put(this.getName(), this);
    }


    public static void removeHouse(String name, Map<String, House> houses) {
        houses.remove(name);
    }

}