package faang.school.godbless.groupingUsersByAge;

import java.util.*;

public class User {

    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    public User(String name, int age, String placeOfWork, String address) {
        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : users) {
            int age = user.getAge();
            if (!groupedUsers.containsKey(age)) {
                groupedUsers.put(age, new ArrayList<>());
            }
            groupedUsers.get(age).add(user);
        }
        return groupedUsers;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getAge() == user.getAge() && Objects.equals(getName(), user.getName()) && Objects.equals(getPlaceOfWork(), user.getPlaceOfWork()) && Objects.equals(getAddress(), user.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getPlaceOfWork(), getAddress());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPlaceOfWork(String placeOfWork) {
        this.placeOfWork = placeOfWork;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
