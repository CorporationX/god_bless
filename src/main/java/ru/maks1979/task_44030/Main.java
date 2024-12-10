package ru.maks1979.task_44030;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        User userJohn = new User("John", 22, "Yandex", "Rublevka");
        User userKatrin = new User("Katrin", 28, "Yandex", "Stavropol");
        User userMike = new User("Mike", 44, "Sber", "Moskow");
        User userAnn = new User("Ann", 22, "Yandex", "Muhosransk");
        User userBoris = new User("Boris", 22, "TaxiLider", "Habarovsk");

        List <User> listOfYoung = new ArrayList<>();
        listOfYoung.add(userJohn);
        listOfYoung.add(userKatrin);
        listOfYoung.add(userMike);
        listOfYoung.add(userAnn);
        listOfYoung.add(userBoris);
        System.out.println(User.groupUsers(listOfYoung));
    }
}
