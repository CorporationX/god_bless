package task4;
import lombok.Data;
import java.util.*;
@Data
public class User {
    public int id;
    public String name;
    public int age;
    public Set<String> actions;
    public Map<User, String> findHobbyLovers(List<User> listOfUsers,
                                             Set<String> overallActions) {
//overallActions = new ArrayList<String>();
//overallActions - большой общий list с активностями.
//а у каждого user есть свой (list) actions c его обственными активностями.
        Map<User, String> map = new HashMap<>();
        for (User user : listOfUsers) {
            for (String userAction : user.getActions()) {
                if (overallActions.contains(userAction)) {
                    map.putIfAbsent(user, userAction);
                    break;
                }

            }
        }
        return map;
    }
}