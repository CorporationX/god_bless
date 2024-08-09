package data.optimization.test;

import data.optimization.DataCenter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class DataCenterTest {
    private DataCenter dataCenter;

    @BeforeEach
    void setUp() {
        dataCenter = new DataCenter();
    }

    @Test
    @DisplayName("Testing get info with")
    void dataCenterTest_getInfo() {
        assertDoesNotThrow(() -> dataCenter.getInfo());
    }
}
