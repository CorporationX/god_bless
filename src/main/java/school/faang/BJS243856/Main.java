package school.faang.BJS243856;

import lombok.val;

public class Main {

    public static void main(String[] args) {

        val warrior = new Warrior("Warrior");

        val archer = new Archer("Archer");
        System.out.println("archer health before attack: " + archer.getHealth());

        warrior.attack(archer);
        System.out.println("archer health after attack: " + archer.getHealth());
    }

}
