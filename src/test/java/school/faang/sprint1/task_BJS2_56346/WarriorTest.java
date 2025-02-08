package school.faang.sprint1.task_BJS2_56346;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тест класса Warrior")
class WarriorTest {
    private Character warrior;
    private Character opponentArcher;
    private int opponentHealth;
    private int warriorAttack;

    @BeforeEach
    public void setUp() {
        warrior = new Warrior("Ахилес сын Пелея");
        opponentArcher =  new Archer("Леголас");
        opponentHealth = opponentArcher.getHealth();
        warriorAttack = warrior.getStrength();
    }

    @Test
    public void attack() {
        warrior.attack(opponentArcher);
        assertEquals(opponentHealth - warriorAttack, opponentArcher.getHealth());
    }

    @Test
    public void zeroHealthOpponent() {
        int maxCountAttack = Math.round(((float) opponentHealth / warriorAttack));

        for (int i = 0; i < maxCountAttack; i++) {
            warrior.attack(opponentArcher);
        }
        assertEquals(0, opponentArcher.getHealth());
    }
}