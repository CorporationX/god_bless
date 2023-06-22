package droid;


import faang.school.godbless.droid.Droid;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DroidTest {
  @Test
  public void sendEncryptedMessageTest() {
    Droid droid = new Droid();
    Droid otherDroid = new Droid();

    String result = droid.sendEncryptedMessage(otherDroid, "Test string", 3);
    String expected = "Whvw#vwulqj";
    assertEquals(expected, result);
  }
}