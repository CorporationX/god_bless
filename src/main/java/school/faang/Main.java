package school.faang;

import school.faang.service.User;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        Set<String> hobbies = new HashSet<>();
        hobbies.add("Футбол");
//        hobbies.add("Рыбалка");
//        hobbies.add("Волейбол");
        hobbies.add("Вышивание");
//        hobbies.add("Программирование");

        User vasya = new User("Вася", 33, new HashSet<>(Arrays.asList("Футбол", "Рыбалка")));
        User petya = new User("Петя", 28, new HashSet<>(Arrays.asList("Волейбол", "Рыбалка")));
        User irina = new User("Ирина", 25, new HashSet<>(Arrays.asList("Волейбол", "Вышивание")));
        User dima = new User("Дима", 28, new HashSet<>(Arrays.asList("Хоккей", "Программирование")));

        users.add(vasya);
        users.add(petya);
        users.add(irina);
        users.add(dima);

//        System.out.println(User.findHobbyLovers(users,hobbies));
//        User.findHobbyLovers(users,hobbies);
        for (Map.Entry<User,String> value : User.findHobbyLovers(users,hobbies).entrySet())
            System.out.println(value.getKey().getName()+" "+ value.getValue());


    }
}

