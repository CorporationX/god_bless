package faang.school.godbless.task.droids;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class DroidTest {
    Droid c3po = new Droid();
    Droid r2d2 = new Droid();
    int encryptKey = 1001;

    @Test
    void assertEncryptKey_correctEncryptKey() {
        assertDoesNotThrow(() -> Droid.assertEncryptKey(encryptKey));
    }

    @Test
    void assertEncryptKey_incorrectEncryptKey() {
        int encryptKeyZero = 0;

        IllegalArgumentException exceptionZero = assertThrows(IllegalArgumentException.class, () -> Droid.assertEncryptKey(encryptKeyZero));
        assertEquals(Droid.EXCEPTION_USELESS_KEY_VALUE, exceptionZero.getMessage());

        int encryptKeyMaxValue = Character.MAX_VALUE * 4;
        IllegalArgumentException exceptionMaxValue = assertThrows(IllegalArgumentException.class, () -> Droid.assertEncryptKey(encryptKeyMaxValue));
        assertEquals(Droid.EXCEPTION_USELESS_KEY_VALUE, exceptionMaxValue.getMessage());

        int encryptKeyNegative = -242;
        IllegalArgumentException exceptionNegative = assertThrows(IllegalArgumentException.class, () -> Droid.assertEncryptKey(encryptKeyNegative));
        assertEquals(Droid.EXCEPTION_NEGATIVE_KEY_VALUE, exceptionNegative.getMessage());
    }

    @Test
    void pairDroidsWithEncryptKey_positiveCase() {
        Droid.pairDroidsWithEncryptKey(c3po, r2d2, encryptKey);

        assertEquals(encryptKey, c3po.getEncryptKey(r2d2));
        assertEquals(encryptKey, r2d2.getEncryptKey(c3po));
    }

    @Test
    void sendEncryptedMessage_positiveCase() {
        c3po.sendEncryptedMessage(r2d2, "Hello there!", encryptKey);
        assertEquals("бюѕѕјЉѝёюћюЊ", r2d2.getLastMessageForDroid(c3po));
    }

    @Test
    void getEncryptKey_positiveCase() {
        Droid.pairDroidsWithEncryptKey(c3po, r2d2, encryptKey);
        assertEquals(1001, c3po.getEncryptKey(r2d2));
    }

    @Test
    void getEncryptKey_withoutPairing() {
        var exception = assertThrows(NoSuchElementException.class, () -> c3po.getEncryptKey(r2d2));
        assertEquals(Droid.EXCEPTION_KEY_NOT_FOUND, exception.getMessage());
    }

    @Test
    void getLastMessageForDroid_positiveCase() {
        Droid.pairDroidsWithEncryptKey(c3po, r2d2, encryptKey);
        c3po.sendEncryptedMessage(r2d2, "Hello there!", c3po.getEncryptKey(r2d2));
        assertEquals("бюѕѕјЉѝёюћюЊ", r2d2.getLastMessageForDroid(c3po));
    }

    @Test
    void getLastMessageForDroid_noMessage() {
        var noSuchElementException = assertThrows(NoSuchElementException.class, () -> r2d2.getLastMessageForDroid(c3po));
        assertEquals(Droid.EXCEPTION_DROID_NOT_FOUND, noSuchElementException.getMessage());
    }
}