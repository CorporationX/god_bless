package faang.school.godbless;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        User user1 = new User("Kevin", 19, "Uber", "Amsterdam");
        User user2 = new User("Alan", 35, "Google", "New York");
        User user3 = new User("Laura Bradley", 35, "Amazon", "London");
        User user4 = new User("Mr. Henderson", 40, "Uber", "London");
        User user5 = new User("Kevin", 27, "Google", "Amsterdam");
        List<User> users = List.of(user1, user2, user3, user4, user5);
        for(Map.Entry<Integer, List<User>> entry : User.groupUsers(users).entrySet()){
            System.out.println("age " + entry.getKey());
            for(User user : entry.getValue()){
                System.out.println(user.getName() + ": place of work - "+ user.getPlaceOfWork() + "; adress - " + user.getAddress());
            }
            System.out.println();
        }

        Archer archer = new Archer("Robin Hood");
        Warrior warrior = new Warrior("Shrek");
        while(archer.health > 0 && warrior.health > 0) {
            if((Math.random() * 10) > 4) {
                archer.attack(warrior);
            } else {
                warrior.attack(archer);
            }
            System.out.println(warrior.getName() + " health: " + warrior.health);
            System.out.println(archer.getName() + " health: " + archer.health);
        }
        if (warrior.health == 0) {
            System.out.println(archer.getName() + " win!");
        } else {
            System.out.println(warrior.getName() + " win!");
        }
    }
}
