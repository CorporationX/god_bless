package faang.school.godbless.abstraction_abstraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void main() {
        Character warrior = new Warrior("Herald");
        Character archer = new Archer("not Herald");

        System.out.println(warrior);
        System.out.println(archer);

        warrior.attack(archer);
        archer.attack(warrior);

        System.out.println(warrior);
        System.out.println(archer);
    }
}