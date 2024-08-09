package faang.school.godbless.task18606;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<User> list = new ArrayList<>();
        list.add(new User("Dima", 44, "MedPrific", "Nikolskaya street"));
        list.add(new User("Igor", 44, "OTP", "Nikolskaya street"));
        list.add(new User("Irina", 35, "Sberbank", "Sudakova street"));
        list.add(new User("Alla", 35, "Pik", "Narodnaya street"));

        System.out.println(User.groupUsers(list));
    }
}
