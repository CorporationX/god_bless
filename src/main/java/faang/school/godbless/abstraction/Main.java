package faang.school.godbless.abstraction;

import faang.school.godbless.abstraction.entity.Archer;
import faang.school.godbless.abstraction.entity.Warrior;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String MESSAGE_ATTACK = "%s attack %s";
        String MESSAGE_HEALTH = "%s health %d";
        String MESSAGE_WINNER = "%s winner!!!";
        Archer archer = new Archer("Legolas");
        Warrior warrior = new Warrior("Aragorn");
        for(int i =0; i<10; i++){
            if(new Random().nextBoolean()){
                System.out.println(String.format(MESSAGE_ATTACK,warrior.getName(),archer.getName()));
                warrior.attack(archer);
                System.out.println(String.format(MESSAGE_HEALTH,archer.getName(),archer.getHealth()));
            }else{
                System.out.println(String.format(MESSAGE_ATTACK,archer.getName(),warrior.getName()));
                archer.attack(warrior);
                System.out.println(String.format(MESSAGE_HEALTH,warrior.getName(),warrior.getHealth()));
            }
        }
        if(warrior.getHealth() > archer.getHealth()){
            System.out.println(String.format(MESSAGE_WINNER,warrior.getName()));
        }else {
            System.out.println(String.format(MESSAGE_WINNER,archer.getName()));
        }

    }
}
