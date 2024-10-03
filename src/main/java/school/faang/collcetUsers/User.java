package school.faang.collcetUsers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class User {
    private int id;
    private String name;
    private int age;
    private List<String> activities;

    public User(int id, String name, int age, List<String> activities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = new ArrayList<String>();
    }

    public void addActivity(String activity) {
        activities.add(activity);
    }


public static Map<User, String> findHobbyLovers (List<User> users,  Set<String> hobbies) {
        Map<User, String> hobbyLovers = new HashMap();

    for (User user : users) {
        for (String hobby : hobbies) {
            if (user.getActivities().contains(hobby)) {
                hobbyLovers.put(user, user.getName() + " увлекается " + hobby);
            }
        }
    }

    return hobbyLovers;
}

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", activities=" + activities +
                '}';
    }

    public static void main(String[] args) {
        User user = new User(1,"Алекс",15,new ArrayList<>() );
        user.addActivity("Бег");
        user.addActivity("Ходьба");

        System.out.println(user);
    }
}
