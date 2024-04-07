package User_Registration;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> test = new ArrayList<>();
        test.add(new User("Victor", 27, "JetBrains", "Hollywood"));
        test.add(new User("Mihail", 25, "X", "Privet Drive 2"));
        test.add(new User("Elena", 30, "LinkedIn", "Green st 3232"));
        User.groupUsers(test);
    }
}