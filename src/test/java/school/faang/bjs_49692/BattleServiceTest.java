package school.faang.bjs_49692;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BattleServiceTest {

    @Test
    void battle() {
        BattleService battleService = new BattleService();
        int actual = battleService.battle();
        int expected = BattleService.getPLAYERS_COUNT();
        Assertions.assertEquals(expected, actual);
    }
}