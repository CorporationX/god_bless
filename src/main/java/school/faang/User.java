package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
@ToString
public class User {
    private int age;
    private String name;
    private String workPlace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> startList) {
        Map<Integer, List<User>> finalMap = new HashMap<>();
        for (var user : startList) {
            List<User> sortedList = finalMap.getOrDefault(user.getAge(), new ArrayList<>());
            sortedList.add(user);
            finalMap.put(user.getAge(), sortedList);
        }

        for (Map.Entry<Integer, List<User>> entryPair : finalMap.entrySet()) {
            System.out.println(entryPair.toString());
        }
        return finalMap;
    }

    public static void main(String[] args) {
        List<User> startList = new ArrayList<>();

        startList.add(new User(25, "Bob", "Google", "Smolensk"));
        startList.add(new User(30, "Ben", "Amazon", "Moscow"));
        startList.add(new User(30, "Bull", "Tesla", "Novgorod"));
        startList.add(new User(30, "Larry", "Pyaterochka", "Saint Petersburg"));
        startList.add(new User(21, "Genry", "Perekrestok", "Tula"));
        startList.add(new User(24, "Gordon", "Netflix", "Orel"));
        startList.add(new User(25, "Masie", "Nvidia", "Saratov"));

        groupUsers(startList);
    }
}