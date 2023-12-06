package faang.school.godbless.collectUsers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public User(){};

    public Set<String> getActivity() {
        return activity;
    }
    Map<User,String> findHobbyLovers(List<User> users, Set<String> setOfActivity){
        Map<User,String> userStringMapResult = new HashMap<>();
        for (User user : users) {
            for (String action : setOfActivity) {
                if (user.getActivity().contains(action)) {
                    userStringMapResult.put(user,action);
                    break;
                }
            }
        }
        return userStringMapResult;
    }

    @Override
    public String toString() {
        return name + ", activity=" + activity;
    }
}
