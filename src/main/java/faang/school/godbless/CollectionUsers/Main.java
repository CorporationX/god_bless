package faang.school.godbless.CollectionUsers;

import java.util.ArrayList;
import java.util.List;

import static faang.school.godbless.CollectionUsers.User.findHobbyLovers;

public class Main {
    public static void main(String[] args) {
        List<User> listUser = new ArrayList<>();
        listUser.add(new User(1, "Василий", 27, new String[]{"шахматы", "велосипед", "кулинария"}));
        listUser.add(new User(2, "Олег", 35, new String[]{"сноуборд", "велосипед", "баскетбол"}));
        listUser.add( new User(3, "Iрина", 35, new String[]{"рукоделие", "волейбол", "кулинария"}));
        listUser.add(new User(4, "Егор", 18, new String[]{"туризм", "баскетбол"}));
        listUser.add(new User(5, "Мария", 22, new String[]{"шахматы", "йога", "рисование"}));

        String[] activities = {"шахматы","плавание", "баскетбол"};

        System.out.println(findHobbyLovers(listUser,activities));
    }
}
