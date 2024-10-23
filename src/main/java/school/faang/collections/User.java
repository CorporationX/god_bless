package school.faang.collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activity;

    public User(int id, String name, int age,Set<String> activity) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activity = activity;
    }

    public Set<String> getActivity() {
        return activity;
    }

    public static Map<User, String> findHobbyLovers (List<User> users , Set<String> activityUsers) {

        Map <User,String> userWithActivity = new HashMap<>();

       for(User user : users) {
          for (String activityUser : activityUsers) {
              if (user.getActivity().contains(activityUser)){
                  userWithActivity.put(user,activityUser);
              }
          }
       }
       return userWithActivity;
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
