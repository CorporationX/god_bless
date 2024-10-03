package abstractionAbstractionTest;

import abstractionAbstraction.Archer;
import abstractionAbstraction.Warrior;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WarriorTest {

    private Warrior warrior;

    @BeforeEach
    void setUp(){
        warrior = new Warrior("Grommash");
    }

    @Test
    @DisplayName("Positive test")
    void attackTest() {
        // Arrange
        Archer archer = new Archer("Silvana");
        // Act
        warrior.attack(archer);
        // Assert
        assertEquals(90, archer.getHp());
    }
}
