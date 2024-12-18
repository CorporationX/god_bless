package grouping_users_by_age;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer,List<User>> groupUsers (List<User> usersList){
        Map<Integer,List<User>> mapUsers = usersList.stream()
                .collect(Collectors
                        .groupingBy(User::getAge));
        return mapUsers;
    }

}
