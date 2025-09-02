package school.faang;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> hobbies;

    public User(int id, String name, int age, Set<String> hobbies) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Set<String> getHobbies() {
        return hobbies;
    }

    public static Map<User, String> findHobbyLovers(Set<String> targetHobbies, List<User> users) {
        Map<User, String> result = new LinkedHashMap<>();

        if (targetHobbies == null || targetHobbies.isEmpty()) {
            return result;
        }
        if (users == null || users.isEmpty()) {
            return result;
        }

        for (User user : users) {
            for (String hobby : user.hobbies) {
                if (targetHobbies.contains(hobby)) {
                    result.put(user, hobby);
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        User oleg = new User(1, "Олег", 11, new HashSet<>(Arrays.asList("химия", "танцы")));
        User katy = new User(2, "Катя", 10, new HashSet<>(Arrays.asList("танцы", "рисование")));
        User misha = new User(3, "Миша", 11, new HashSet<>(Arrays.asList("бокс", "рыбалка")));

        List<User> users = Arrays.asList(oleg, katy, misha);

        Set<String> targetHobbies = new HashSet<>(Arrays.asList("танцы", "химия"));

        Map<User, String> lovers = findHobbyLovers(targetHobbies, users);

        for (Map.Entry<User, String> entry : lovers.entrySet()) {
            System.out.println(entry.getKey().getName() + " любит " + entry.getValue());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
