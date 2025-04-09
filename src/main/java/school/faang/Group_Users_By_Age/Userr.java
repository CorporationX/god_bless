package school.faang.Group_Users_By_Age;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@lombok.Getter
@lombok.Setter
public class Userr {

    private String name;
    private int age;
    private String workplace;
    private String adress;

    public Userr(String name, int age, String workplace, String adress) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.adress = adress;
    }


    public static Map<Integer, List<Userr>> groupUsers(List<Userr> users) {

        Map<Integer, List<Userr>> usersMap = new HashMap<>();

        for (Userr user : users) {
            usersMap.computeIfAbsent(user.getAge(), a -> new ArrayList<>()).add(user);
        }
        return usersMap;
    }

}