package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String workPlace;
    private String adres;

    public static Map groupUsers(List<User> userData) {
        Map<Integer, List<User>> result = new HashMap<>();
        List<Integer> allAges = new ArrayList<>();

        for (int i = 0; i < userData.size(); i++) {
            if (!allAges.contains(userData.get(i).age)) {
                allAges.add(userData.get(i).age);
            }
        }

        for (int i : allAges) {
            List<User> temporaryList = new ArrayList<>();

            for (int j = 0; j < userData.size(); j++) {
                User x = userData.get(j);

                if (x.age == i) {
                    temporaryList.add(x);
                }
            }

            result.put(i, temporaryList);
        }
        return result;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public String getAdres() {
        return adres;
    }
}