package school.faang.task_43822;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Warrior w = new Warrior("Erik");
        Archer a = new Archer("Piter");
        System.out.println("Stats before the fight : \nWarrior : " + w + "\nArcher : " + a);

        System.out.println("The warrior is really mad and motivated! He is trying to attack her!");
        int random = new Random().nextInt() % 2;
        if(random == 1){
            w.attack(a);
            System.out.println("The archer was attacked. His HP was decreased : " + a);
        } else {
            System.out.println("The warrior was not ready to attack. Archer is going to attack!");
            a.attack(w);
        }

        System.out.println("They understood that it is the game. They are in the code of regular student. \nThe don`t know what to do and decide to stop fighting and try to escape the world!");
        System.out.println("The game is over : Stats : \nWarrior : " + w + "\nArcher : " + a);
    }
}
