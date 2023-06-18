package faang.school.godbless;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    public int id;
    public String name;
    public int age;
    public List <String> actions;

    public Map<User, String> findHobbyLovers(List<String> listOfUsers, List <String> overallActions){
        listOfUsers = new ArrayList<String>();
        overallActions = new ArrayList<String>();
        // overallActions - большой общий list с активностями
        // а у каждого user есть свой (list) actions  его обственными активностями
        Map <User, String > map = new HashMap<>();
        for (String user: listOfUsers){
            for (String commonAction: overallActions) {
                if (user.contains(commonAction))
                map.putIfAbsent(user, commonAction);
            }
        }
        return map;
    }
}

//    public Map<User, String> findHobbyLovers(List<String> listOfUsers, List <String> actions){
//        listOfUsers = new ArrayList<String>();
//        Map <User, String > map = new HashMap<>();
//        for (String user: listOfUsers){
//            for (String action: actions) {
//                map.putIfAbsent(user, action);
//            }
//        }
//        return map;