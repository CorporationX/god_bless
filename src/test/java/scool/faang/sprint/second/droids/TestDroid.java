package scool.faang.sprint.second.droids;

import org.junit.Test;
import org.mockito.Mockito;
import school.faang.sprint.second.droids.Droid;

public class TestDroid {
    @Test
    public void testSendMessage() {
        Droid r2d2 = Mockito.mock(Droid.class);
        Droid c3po = Mockito.mock(Droid.class);

        r2d2.sendMessage(c3po, "Message", 1);
        Mockito.verify(r2d2, Mockito.times(1)).sendMessage(c3po, "Message", 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrowWhenCreateDroidWithBlankName() {
        new Droid("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrowWhenMessageBlank() {
        Droid r2d2 = new Droid("r2d2");
        Droid c3po = new Droid("c3po");

        r2d2.sendMessage(c3po, "", 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrowWhenEncryptionKeyIsBlank() {
        Droid r2d2 = new Droid("r2d2");
        Droid c3po = new Droid("c3po");

        r2d2.sendMessage(c3po, "Message", -1);
    }
}
