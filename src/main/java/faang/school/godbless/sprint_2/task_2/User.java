package faang.school.godbless.sprint_2.task_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private String name;
    private int age;
    private String placeOfWork;
    private String address;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int AGE_LIMIT = 18;

    public User(String name, int age, String placeOfWork, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Your need to enter a name!");
        }
        if (age < AGE_LIMIT) {
            throw new IllegalArgumentException("Your age is less than.");
        }
        if (!(VALID_JOBS.contains(placeOfWork))) {
            throw new IllegalArgumentException("Your job does not match those offered.");
        }
        if (!(VALID_ADDRESSES.contains(address))) {
            throw new IllegalArgumentException("Your address does not match those offered.");
        }
        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();

        for (User user : users) {
            int age = user.getAge();
            if (groupedUsers.containsKey(age)) {

                groupedUsers.get(age).add(user);

            } else {
                List<User> userList = new ArrayList<>();
                userList.add(user);
                groupedUsers.put(age, userList);
            }
        }
        return groupedUsers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPlaceOfWork() {
        return placeOfWork;
    }

    public void setPlaceOfWork(String placeOfWork) {
        this.placeOfWork = placeOfWork;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static void main(String[] args) {
        User user_1 = new User("Volodya", 30, "Meta", "Los-Angeles");
        //User user_2 = new User("Irina", 27, "Amazon", "London");
        System.out.println(user_1.getPlaceOfWork());
        //System.out.println(user_2.getPlaceOfWork());
    }
}
