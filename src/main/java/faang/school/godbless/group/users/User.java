package faang.school.godbless.group.users;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;
    private String adress;
    private String workPlace;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(int id, String name, int age, Set<String> activities, String adress, String workPlace) {
        validation(name, age, adress, workPlace);
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = activities;
        this.adress = adress;
        this.workPlace = workPlace;
    }


    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || this.getClass() != object.getClass()) return false;
        User user = (User) object;
        return this.id == user.id && Objects.equals(this.name, user.name) && this.age == user.id && Objects.equals(this.activities, user.activities) && Objects.equals(this.adress, user.adress) && Objects.equals(this.workPlace, user.workPlace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, activities, adress, workPlace);
    }

    public static Map<User, String> createMapWithUsers(List<User> users, Set<String> activities) {
        Map<User, String> usersWithActivities = new HashMap<>();
        for (User user : users) {
            for (String activity : user.activities) {
                if (activities.contains(activity)) {
                    usersWithActivities.put(user, activity);
                    break;
                }
            }
        }
        return usersWithActivities;
    }

    private void validation(String name, int age, String adress, String workPlace) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Не указано имя");
        if (age < 18) throw new IllegalArgumentException("Возраст не соотвуетсвует условиям");
        if (!(VALID_ADDRESSES.contains(adress))) throw new IllegalArgumentException("Адресс не соотвуетсвует условиям");
        if (!(VALID_JOBS.contains(workPlace)))
            throw new IllegalArgumentException("Место работы не соотвуетсвует условиям");
    }
}
