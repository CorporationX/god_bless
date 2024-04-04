package faang.school.godbless.module.core.collect;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        User ivan = new User(1, "Иван", 55, List.of("Играть", "Есть", "Смотреть"));
        User vova = new User(2, "Володька", 32, List.of("Играть", "Смотреть", "Ютуб"));
        User lilya = new User(3, "Лилия", 16, List.of("Думать"));
        List<String> activitiesToFind = List.of("Думать", "Ютуб");
        List<User> users = List.of(ivan, vova, lilya);
        
        System.out.println(User.findHobbyLovers(users, activitiesToFind));
    }
}
