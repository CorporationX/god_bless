package JavaCore_4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {

    private int id;
    private String name;
    private int age;
    private Set<String> actives;

    public User(int id, String name, int age, Set<String> actives) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.actives = actives;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> actives){
        HashMap<User, String> coincidence = new HashMap<>();
        for (User user: users) {
            for (String active: user.getActives()){
                if (actives.contains(active)){
                    coincidence.put(user, active);
                    break;
                }
            }
        }
        return coincidence;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setActives(Set<String> actives) {
        this.actives = actives;
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

    public Set<String> getActives() {
        return actives;
    }

}
