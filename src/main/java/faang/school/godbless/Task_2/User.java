package faang.school.godbless.Task_2;

import lombok.Data;

import java.util.*;

@Data
public class User {

    private String name;
    private Integer age;
    private String workplace;
    private String address;
    private static final Set<String> VALID_JOBS =
            new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES =
            new HashSet<>(Arrays.asList("London", "New - York", "Amsterdam"));

    public User(String name, Integer age, String workplace, String address) {

        if (name != null && age >= 18 && VALID_JOBS.contains(workplace) && VALID_ADDRESSES.contains(address)) {
            this.name = name;
            this.age = age;
            this.workplace = workplace;
            this.address = address;
        } else throw new IllegalArgumentException();
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {

        Map<Integer, List<User>> listMap = new HashMap<>();

        for (int i = 0; i < users.size(); i++) {
            List<User> list = new ArrayList<>();
            Integer age = users.get(i).getAge();

            for (User user : users) {

                if (user.getAge() == age) {
                    list.add(user);
                }
            }
            listMap.put(age, list);
        }
        return listMap;
    }
}
