package school.faang.sprint1.bjs2_43887;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String args[]) {
        List<User> users = new ArrayList<User>();
        users.add(new User("John", 29, "Company A", "123 Main st."));
        users.add(new User("Mike", 31, "Company B", "Mike address"));
        users.add(new User("Diana", 29, "Company Z", "address of Diana"));
        users.add(new User("Tim", 31, "company T", "address T"));
        users.add(new User("Donald", 79, "Government", "USA"));

        Map<Integer, List<User>> groupByAge = User.groupUsers(users);

        for(var pair : groupByAge.entrySet()) {
            System.out.print(pair.getKey() + " : ");
            for (User user : pair.getValue()){
                 User.printUserObject(user);
            }
            System.out.println();
        }
    }
}
