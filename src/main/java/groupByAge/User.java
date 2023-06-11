package groupByAge;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;

    public static Map<Integer,List<User>> groupUsers (List<User> listUsers){
        Map<Integer, List<User> > sortByAge = new HashMap<>();
            for (User listUser : listUsers) {
                int i = 0;
                if(sortByAge.containsKey(listUser.getAge())){
                    ArrayList<User> usersSameAge = new ArrayList<User>();
                    usersSameAge.add(listUser);
                    sortByAge.put(listUser.getAge(),usersSameAge);
                }else{
                    //   sortByAge.put(listUser.getAge(), .get(i));
                }
                i++;
            }
        return sortByAge;
    }
}
