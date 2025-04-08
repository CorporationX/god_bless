package school.faang.bjs2_67957;

import lombok.val;

public class Main {
    public static void main(String[] args) {
        val warrior = new Warrior("Alex");
        val archer = new Archer("Lena");

        warrior.attack(archer);
        archer.attack(warrior);
    }
}
