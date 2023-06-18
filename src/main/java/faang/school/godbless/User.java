package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    public int id;
    public String name;
    public int age;
    public List<String> actions;

    public Map<String, String> findHobbyLovers(List<String> listOfUsers, List<String> overallActions) {
        listOfUsers = new ArrayList<String>();
        overallActions = new ArrayList<String>();
        // overallActions - большой общий list с активностями
        // а у каждого user есть свой (list) actions  его обственными активностями
        Map<String, String> map = new HashMap<>();
        for (String user : listOfUsers) {
            for (String userAction : actions) {
                if (overallActions.contains(userAction))
                    map.putIfAbsent(user, userAction);
            }
        }
        return map;
    }
}
