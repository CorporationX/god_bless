package school.faang;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@AllArgsConstructor
@Data
public class User {
    private String name;
    private int age;
    private String job;

    public static Map<Integer, List<User>> groupUsers (List<User> UsersList){
        Map<Integer, List<User>> groupedUsers = new HashMap<>();

        for (int i = 0; i < UsersList.size(); i++) {
            List<User> TempList = new ArrayList<>();

            for (int j = 0; j < UsersList.size(); j++) {
                if (Objects.equals(UsersList.get(i).getAge(), UsersList.get(j).getAge())){
                    TempList.add(UsersList.get(j));
                    groupedUsers.put(UsersList.get(i).getAge(), TempList);
                }
            }
        }
        return groupedUsers;
    }

}
