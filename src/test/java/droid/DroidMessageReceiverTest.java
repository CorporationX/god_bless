package droid;

import faang.school.godbless.droid.DroidMessageReceiver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DroidMessageReceiverTest {
  @Test
  public void receiveEncryptedMessageTest() {
    DroidMessageReceiver droid = new DroidMessageReceiver();

    String result = droid.receiveEncryptedMessage( "Whvw#vwulqj", 3);
    String expected = "Test string";
    assertEquals(expected, result);
  }
}
