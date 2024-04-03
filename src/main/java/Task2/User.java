package Task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class User {
    private final String name;
    private int age;
    private String adress;
    private String placeOfWork;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public int age() {
        return age;
    }

    public static Map<Integer, ArrayList<User>> groupUsers(List<User> array) {
        HashMap<Integer, ArrayList<User>> answer = new HashMap<>();
        for (User elem : array) {
            if (!answer.containsKey(elem.age())) {
                ArrayList<User> list = new ArrayList<>();
                answer.put(elem.age(), list);
            }
            answer.get(elem.age()).add(elem);
        }
        return answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(adress, user.adress) && Objects.equals(placeOfWork, user.placeOfWork);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, adress, placeOfWork);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
