package JavaCore_4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {

    private int id;
    private String name;
    private int age;
    private Set<String> activePul;

    public static Map<User, String> findHobbyLovers(List<User> user, Set<String> actives){
        HashMap<User, String> check = new HashMap<>();
        for (User userCheck: user) {
            for (String activeCheck: userCheck.getActivePul()){
                if (actives.contains(activeCheck)){
                    check.put(userCheck, activeCheck);
                    break;
                }
            }
        }
        return check;
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

    public Set<String> getActivePul() {
        return activePul;
    }

}
