package school.faang.bjs2_85502;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User {

    private int id;
    private String name;
    private int age;
    private Set<String> activity;

    public static Map<User, String> findHobbyLovers(List<User> usersList, Set<String> activitySet) {
        Map<User, String> mapUsersAndActivity = new HashMap<>();
        for (int i = 0; i < usersList.size(); i++) {
            User user = usersList.get(i);
            Set<String> userActivitySet = user.getActivity();
            String activity=null;
            for (String str: userActivitySet){
                if(activitySet.contains(str)){
                    activity = str;
                    break;
                }
            }
            if (activity !=null) {
                mapUsersAndActivity.put(usersList.get(i), activity);
            }
        }
        return mapUsersAndActivity;
    }
}
