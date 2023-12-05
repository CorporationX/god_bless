package faang.school.godbless.groupUsersByAge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        HashMap<Integer, List<User>> group = User.groupUsers(createUsers());

        for (Map.Entry<Integer, List<User>> entry : group.entrySet()) {
            Integer key = entry.getKey();
            List<User> users = entry.getValue();

            System.out.print(key + " - ");
            StringBuilder usersName = new StringBuilder();
            for (User user : users) {
                usersName.append(user.getName()).append(" ");
            }
            System.out.println(usersName.toString().trim());
        }
    }
    private static List<User> createUsers() {
        List<User> users = new ArrayList<>();

        users.add(new User("John", 32, User.VALID_JOBS.Amazon, User.VALID_ADDRESS.Amsterdam));
        users.add(new User("Erick", 32, User.VALID_JOBS.Google, User.VALID_ADDRESS.New_York));

        users.add(new User("Bred", 31, User.VALID_JOBS.Uber, User.VALID_ADDRESS.London));
        users.add(new User("John", 31,  User.VALID_JOBS.Google, User.VALID_ADDRESS.New_York));

        users.add(new User("Seth", 30, User.VALID_JOBS.Amazon, User.VALID_ADDRESS.Amsterdam));
        users.add(new User("Palmer", 30, User.VALID_JOBS.Amazon, User.VALID_ADDRESS.New_York));

        users.add(new User("Eddy", 35, User.VALID_JOBS.Amazon, User.VALID_ADDRESS.Amsterdam));
        users.add(new User("Christopher", 35, User.VALID_JOBS.Google, User.VALID_ADDRESS.New_York));

        users.add(new User("Kenny", 28, User.VALID_JOBS.Amazon, User.VALID_ADDRESS.Amsterdam));
        users.add(new User("Collin", 28, User.VALID_JOBS.Google, User.VALID_ADDRESS.New_York));

//        users.add(new User("Little", 17, User.VALID_JOBS.Amazon, User.VALID_ADDRESS.Amsterdam));


        return users;
    }
}
