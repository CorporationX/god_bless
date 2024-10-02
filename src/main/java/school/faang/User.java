package school.faang;

import java.util.*;

public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESS = Set.of("London", "New York", "Amsterdam");
    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    public User(String name, int age, String placeOfWork, String address) {
        try {
            if (name.length() > 0) {
                this.name = name;
            }
            if (age > 17) {
                this.age = age;
            }
            if (placeOfWork.equals(VALID_JOBS)) {
                this.placeOfWork = placeOfWork;
            }
            if (address.equals(VALID_ADDRESS)) {
                this.address = address;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Exception");
        }
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupUsers = new HashMap<>();
        for (User user : users) {
            groupUsers.computeIfAbsent(user.getAge(), age -> new ArrayList<>()).add(user);
        }
        return groupUsers;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPlaceOfWork() {
        return placeOfWork;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", placeOfWork='" + placeOfWork + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}