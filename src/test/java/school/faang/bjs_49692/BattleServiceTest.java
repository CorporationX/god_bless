package school.faang.bjs_49692;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BattleServiceTest {

    @Test
    void battle() {
        BattleService battleService = new BattleService();
        Assertions.assertDoesNotThrow(battleService::battle);
    }
}