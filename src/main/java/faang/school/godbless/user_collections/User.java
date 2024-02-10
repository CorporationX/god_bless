package faang.school.godbless.user_collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class User {
    private long id;
    private String name;
    private int age;
    private Set<String> userActivities;


    public User(long id, String name, int age, Set<String> userActivities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.userActivities = userActivities;
    }

    public Set<String> getUserActivities(){
        return userActivities;
    }

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> activities){
        Map<User, String> usersWithActivities = new HashMap<>();
        for(User user:users){
            String activity=hasFirstCommonActivity(user.getUserActivities(),activities );
            if(activity!=null){
                usersWithActivities.put(user, activity);
            }
        }
        return usersWithActivities;
    }
    private String hasFirstCommonActivity(Set<String> userActivities, Set<String> activities){
           for(String activity : userActivities){
               if(activities.contains( activity )){
                   return activity;
               }
           }
        return null;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && Objects.equals(name, user.name );
    }
    @Override
    public int hashCode() {
        return Objects.hash( id, name, age );
    }
}
