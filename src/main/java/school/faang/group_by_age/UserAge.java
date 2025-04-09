package school.faang.group_by_age;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class UserAge {

    private String name;
    private Integer age;
    private String work;
    private String address;

    public static Map<Integer, List<UserAge>> groupUserByAge(Integer ageUser,List<UserAge> userAgeList){
        Map<Integer,List<UserAge>> mapSortedUserByAge = new HashMap<>();
        List<UserAge> ageList = new ArrayList<>();

        for(UserAge userAge : userAgeList){
            if(Objects.equals(userAge.getAge(), ageUser)){
                ageList.add(userAge);
                mapSortedUserByAge.put(ageUser, ageList);
            }
        }

        return mapSortedUserByAge;
    }
}
