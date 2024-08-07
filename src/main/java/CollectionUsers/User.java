package CollectionUsers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> actions;

    public User(int id, String name, int age, Set<String> actions) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.actions = actions;
    }

    public static void main(String[] args) {

        List<User> testUserList = new ArrayList<>();

        testUserList.add(new User(90,"Kirill", 18, Set.of("Hokkey", "Football", "Litrball")));
        testUserList.add(new User(90,"Ivan", 18, Set.of("Hokkey","Football")));
        testUserList.add(new User(90,"Kolya", 18, Set.of("Litrball","Hokkey","Football")));

        Set<String> testSet = Set.of("Football","Litrball","Badminton");

        Map<String, String> map = findHobbyLovers(testUserList, testSet);

        for(Map.Entry<String,String> pair : map.entrySet()){
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
    }

    public static Map<String, String> findHobbyLovers(List<User> userList, Set<String> actionSet) {

        Map<String, String> hobbyMap = new LinkedHashMap<>();

        for (User u : userList) {
            for (String action : u.actions) {
                if (actionSet.contains(action)) {
                    hobbyMap.put(u.name, action);
                    break;
                }
            }

        }


        return hobbyMap;
    }
}
