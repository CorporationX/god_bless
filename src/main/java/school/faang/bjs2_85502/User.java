package school.faang.bjs2_85502;

import lombok.Getter;

import java.util.*;

@Getter
public class User {

    private int id;
    private String name;
    private int age;
    private Set<String> activity;

    public User(int id, String name, int age, Set<String> activity) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activity = activity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id == user.id
                && age == user.age
                && Objects.equals(name, user.name)
                && Objects.equals(activity, user.activity);
    }

    public static Map<User, String> findHobbyLovers(List<User> usersList, Set<String> activitySet) {
        Map<User, String> mapUsersAndActivity = new HashMap<>();
        for (int i = 0; i < usersList.size(); i++) {
            String activity = String.valueOf(activitySet.stream()
                    .filter(usersList.get(i).getActivity()::contains)
                    .findFirst());
            if (!activity.isBlank()) {
                mapUsersAndActivity.put(usersList.get(i), activity);
            }
        }
        return mapUsersAndActivity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, activity);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", activity=" + activity +
                '}';
    }
}
