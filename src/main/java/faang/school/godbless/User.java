package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
public class User {
    @Setter
    private int id;
    @Setter
    private String name;
    @Setter
    private int age;
    @Setter
    private Set<String> activities;

    public User(int id, String name, int age, Set<String> activities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = activities;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> hobbyLovers = new HashMap<>();

        for (User user : users) {
            Set<String> userActivities = user.getActivities();
            for (String activity : userActivities) {
                if (activities.contains(activity)) {
                    hobbyLovers.put(user, activity);
                    break;
                }
            }
        }
        return hobbyLovers;
    }

    public static void main(String[] args) {
        Set<String> findActivities1 = Set.of("Футбол", "Лыжи", "Плавание");
        Set<String> findActivities2 = Set.of("Хокей", "Музыка", "Программирование");
        Set<String> findActivities3 = Set.of("Путешествия", "Фотографирование", "Бег");

        List<User> user = Arrays.asList(
                new User(1, "Behzod", 24, findActivities1),
                new User(2, "Sasha", 35, findActivities2),
                new User(3, "Masha", 28, findActivities3)
        );

        Set<String> searchHobbies = Set.of("Музыка", "Бег");

        Map<User, String> activityLovers = User.findHobbyLovers(user, searchHobbies);
        for (Map.Entry<User, String> entry : activityLovers.entrySet()) {
            System.out.println("Пользователь: " + entry.getKey().getName());
            System.out.println("Общее хобби: " + entry.getValue());
            System.out.println();
        }
    }
}
