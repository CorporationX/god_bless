package school.faang;


import school.faang.rpg.Archer;
import school.faang.rpg.Character;
import school.faang.rpg.Warrior;
import school.faang.userregister.User;

public class Main {
    public static void main(String[] args) {

        /*// https://faang-school.atlassian.net/browse/BJS2-43760

        User anny = new User("Anny", 25, "Google", "Amsterdam");
        User kenny = new User("Kenny", 29, "Uber", "London");
        User louis = new User("Louis", 32, "Amazon", "New York");*/


        // https://faang-school.atlassian.net/browse/BJS2-43910
        Character warrior = new Warrior("Jon Jones", 65, 15, 65);
        Character archer = new Archer("David Beckham", 30, 56, 75);
        System.out.println(warrior);
        System.out.println(archer);
        warrior.attack(archer);
        archer.attack(warrior);
        System.out.println(warrior);
        System.out.println(archer);
    }
}
