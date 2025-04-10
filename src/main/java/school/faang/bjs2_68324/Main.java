package school.faang.bjs2_68324;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        User nonameUser = new User("", 19, "Google", "Amsterdam");
        User babyUser = new User("Miras", 1, "Google", "Amsterdam");
        User notValidJobUser = new User("Miras", 19, "Yandex", "Amsterdam");
        User notValidAddressUser = new User("Miras", 19, "Google", "Moscow");

        List<User> users = List.of(nonameUser, babyUser, notValidJobUser, notValidAddressUser);
        for (User user : users) {
            System.out.println(user.toString());
        }
    }
}
