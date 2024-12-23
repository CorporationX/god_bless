package school.faang.bjs_48625;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WeasleyFamilyTest {

    @Test
    void familyWork() {
        WeasleyFamily weasleyFamily = new WeasleyFamily();
        Assertions.assertDoesNotThrow(weasleyFamily::familyWork);
    }
}