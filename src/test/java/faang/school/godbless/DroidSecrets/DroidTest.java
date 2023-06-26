package faang.school.godbless.DroidSecrets;

import faang.school.godbless.revert.Example;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class DroidTest {

    Droid c3po = new Droid();
    DroidMessageReceiver isr4r = new DroidMessageReceiver();
    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @Test
    public void testString() {
        c3po.sendEncryptedMessage(isr4r,"may the Force be with you",3);
        Assertions.assertEquals ("may the Force be with you", output.toString());
    }

    @AfterEach
    public void cleanUpStreams() {
        System.setOut(null);
    }
}