package faang.school.godbless.task_004;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public record User(String name, int age, String placework, String address) {
    static Set<String> VALID_JOBS = Set.of("Google","Uber", "Amazon");
    static Set<String> VALID_ADDRESSES = Set.of("London","New York", "Amsterdam");

    public User(String name, int age, String placework, String address) {
        if(validInput(name, age, placework, address)){
            this.name = name;
            this.age = age;
            this.placework = placework;
            this.address = address;
        } else {
            throw new IllegalArgumentException("Invalid parameters");
        }

    }

    private boolean validInput(String name, int age, String placework, String address) {
        if(name == null
                || age < 18
                || !VALID_JOBS.contains(placework)
                || !VALID_ADDRESSES.contains(address)){
            return false;
        }
        return true;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupUsers = new HashMap<>();

        for (User user : users) {
            Integer ageFilter = user.age();

            // Если возсрастной группа ещё нет,
            if (!groupUsers.containsKey(ageFilter)) {
                // то добавляем группу(ключ) и пустой список
                groupUsers.put(ageFilter, new ArrayList<>());
            }

            // добавляем пользователя в группу.
            groupUsers.get(ageFilter).add(user);
        }

        return groupUsers;
    }

}
