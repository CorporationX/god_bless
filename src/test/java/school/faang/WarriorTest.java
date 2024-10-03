package school.faang;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WarriorTest {

    @Test
    void attack_shouldDecreaseHealthOfCharacterByPower(){
        // given
        int expectedHealth = 90;
        Warrior warrior = new Warrior("Warrior");
        Archer archer = new Archer("Archer");

        // when
        warrior.attack(archer);

        // then
        assertThat(archer.health).isEqualTo(expectedHealth);
    }

}