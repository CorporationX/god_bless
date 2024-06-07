package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private int id;
    private String name;
    private int age;
    private List<String> activities;

    public User(int id, String name, int age, List<String> activities){
        this.id=id;
        this.name=name;
        this.age=age;
        this.activities=activities;
    }

    public static Map<User, List<String>> findHobbyLovers(List<User> user, List<String> listOfActivities){
        Map<User, List<String>> result = new HashMap<>();
        for (User key : user) {
            List<String> listActivities = key.getActivities();
            for (String s : listActivities) {
                if(listOfActivities.contains(s)){
                    if(!result.containsKey(key)){
                        result.put(key, new ArrayList<>());
                    }
                    result.get(key).add(s);
                }
            }
        }



        for (Map.Entry<User, List<String>> entry: result.entrySet()) {
            System.out.println(entry.getKey()+": "+entry.getValue());
        }

        return result;
    }

    public List<String> getActivities() {
        return activities;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String toString(){
        return getName();
    }
}

