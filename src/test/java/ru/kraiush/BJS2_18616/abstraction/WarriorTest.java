package ru.kraiush.BJS2_18616.abstraction;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import school.faang.abstraction.Character;
import school.faang.abstraction.Warrior;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WarriorTest {

    @Test
    @DisplayName("Атака другого перса")
    public void attack_anotherCharacterAttacked() {
        //arrange
        Character target = new Warrior("Груша для битья");
        school.faang.abstraction.Character character = new Warrior("Axe");

        //act
        character.attack(target);

        //assert
        assertEquals(100 - character.getStrength(),
                target.getHealth());
    }

    @Test
    @DisplayName("Атака себя самого")
    public void attack_AttackingYourself_throwsIllegalException() {
        //arrange
        Character character = new Warrior("Axe");

        //act & assert
        assertThrows(IllegalArgumentException.class, () -> character.attack(character));
    }
}
