package BSJS1981;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public Set<String> getActivity() {
        return activity;
    }

    public void setActivity(Set<String> activity) {
        this.activity = activity;
    }

    private int id;

    public String getName() {
        return name;
    }

    private String name;
    private byte age;
    private Set<String> activity;
    public User(int id, String name, byte age, Set<String> activity){
        this.id = id;
        this.name = name;
        this.age = age;
        this.activity = activity;
    }
    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activityes){
        Map<User, String> LoveHobby = new HashMap<>();
            for (User user : users){
                for(String hobby : user.activity){
                  if (activityes.contains(hobby)){
                      LoveHobby.put(user,hobby);
                  }
                }
         }
        return LoveHobby;
    }

}
