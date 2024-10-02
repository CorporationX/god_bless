package school.faang;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    private Warrior warrior;
    private Archer archer;

    @BeforeEach
    void setUp() {
        warrior = new Warrior("Воен");
        archer = new Archer("Луковка");
    }

    // Проверим, что создаются экземпляры классов Воин и Лучник
    @Test
    void testWarriorAndArcherInitialization() {
        assertEquals("Воен", warrior.getName());
        assertEquals("Луковка", archer.getName());
    }

    // Проверим, что после атаки воина у лучника останется 90 здоровья
    @Test
    void testWarriorAttack() {
        warrior.attack(archer);
        assertEquals(90, archer.getHp());
    }

    // Проверим, что после двух атак лучника у воина останется 80 здоровья
    @Test
    void testArcherDoubleAttack() {
        archer.attack(warrior);
        archer.attack(warrior);
        assertEquals(80, warrior.getHp());
    }
}