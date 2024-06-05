package faang.school.godbless;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    public static final Set VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    public static final Set VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));

    private String name;
    private int age;
    private String workPlace;
    private String address;

    public User(String name, int age, String workPlace, String address) throws IllegalArgumentException {
        if (!name.isEmpty() && age >= 18 && VALID_JOBS.contains(workPlace) && VALID_ADDRESSES.contains(address)) {
            this.name = name;
            this.age = age;
            this.workPlace = workPlace;
            this.address = address;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

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
}