package faang.school.godbless.CollectionUsers;

import java.util.*;

import static faang.school.godbless.CollectionUsers.User.findHobbyLovers;

public class Main {
    public static void main(String[] args) {
        List<User> listUser = new ArrayList<>();
        listUser.add(new User(1, "Василий", 27, new HashSet<String>(Arrays.asList("велосипед", "плавание", "шахматы"))));
        listUser.add(new User(2, "Олег", 35, new HashSet<String>(Arrays.asList("плавание", "велосипед", "баскетбол"))));
        listUser.add( new User(3, "Iрина", 35,new HashSet<String>(Arrays.asList("рукоделие", "волейбол", "кулинария"))));
        listUser.add(new User(4, "Егор", 18, new HashSet<String>(Arrays.asList("туризм", "баскетбол"))));
        listUser.add(new User(5, "Мария", 22, new HashSet<String>(Arrays.asList("йога","шахматы", "рисование"))));

        Set<String> activities = Set.of("шахматы","плавание", "баскетбол");

        System.out.println(findHobbyLovers(listUser,activities));
    }
}
