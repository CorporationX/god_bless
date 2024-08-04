package faang.school.godbless.dolbahlop;

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
    private String placeOfWork;
    private String address;

   public static Map<Integer, List<User>> groupUsers(List<User> users){
       if (users == null){
           return null;
       }
       Map<Integer, List<User>> mapOfAge = new HashMap<>();
       for (User user : users){
           if (mapOfAge.containsKey(user.getAge())){
               List<User> listOfUsers = new ArrayList<>();
               listOfUsers.add(user);
               mapOfAge.put(user.getAge(), listOfUsers);
           }
           else {
               mapOfAge.get(user.getAge()).add((user));
           }
       }
       return mapOfAge;
   }
}
