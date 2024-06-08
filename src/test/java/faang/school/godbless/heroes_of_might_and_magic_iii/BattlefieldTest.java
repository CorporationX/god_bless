package faang.school.godbless.heroes_of_might_and_magic_iii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattlefieldTest {
    @Test
    void battlefield() {
        Battlefield battlefield = new Battlefield();
        System.out.println(battlefield.battle().name);
    }
}