package userCollection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private int id;
    private String name;
    private int age;
    private String[] activity;

    public User(int id, String name, int age, String[] activity) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activity = activity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String[] getActivity() {
        return activity;
    }

    public void setActivity(String[] activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", activity=" + Arrays.toString(activity) +
                '}';
    }

    public static Map<User, String> findHobbyLovers(List<User> users, String[] act) {

        Map<User, String> result = new HashMap<>();
        Arrays.sort(act);

        for (User u : users) {
            for (String a : act) {
                if (Arrays.binarySearch(u.activity, a) > -1) {
                    result.put(u, a);
                    break;
                }
            }
        }
        return result;
    }
}