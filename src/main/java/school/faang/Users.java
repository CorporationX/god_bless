package school.faang;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Users {
    private String nameUser;
    private int userAge;
    private String placeOfWork;
    private String userAddress;

    public Users(String nameUser, int userAge, String placeOfWork, String userAddress) {
        this.nameUser = nameUser;
        this.userAge = userAge;
        this.placeOfWork = placeOfWork;
        this.userAddress = userAddress;
    }

    public int getAge() {
        return userAge;
    }

    public static Map<Integer, List<Users>> groupUsers(List<Users> users) {
        Map<Integer, List<Users>> result = new HashMap<>();

        for (Users user : users) {
            int age = user.getAge();
            if (!result.containsKey(age)) {
                result.put(age, new ArrayList<>());
            }
            result.get(age).add(user);

        }
        return result;
    }
}
