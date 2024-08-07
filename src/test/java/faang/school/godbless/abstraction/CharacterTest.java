package faang.school.godbless.abstraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {
    @Test
    void warriorHitsArcher(){
        Warrior warrior = new Warrior("Hellfist");
        Archer archer = new Archer("Adorellan");
        warrior.Attack(archer);
        assertEquals(90, archer.health);
    }
    @Test
    void archerHitsWarrior(){
        Warrior warrior = new Warrior("Hellfist");
        Archer archer = new Archer("Adorellan");
        archer.Attack(warrior);
        assertEquals(90, warrior.health);
    }
    @Test
    void strongWarriorHitsArcher(){
        Warrior warrior = new Warrior("Hellfist");
        Archer archer = new Archer("Adorellan");
        warrior.strength = 35;
        warrior.Attack(archer);
        assertEquals(65, archer.health);
    }
    @Test
    void strongArcherHitsWarrior(){
        Warrior warrior = new Warrior("Hellfist");
        Archer archer = new Archer("Adorellan");
        archer.agility = 27;
        archer.Attack(warrior);
        assertEquals(73, warrior.health);
    }

}