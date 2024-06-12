package faang.school.godbless.task_13_dataCenter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DataCenterTest {
    @Test
    public void testInit() {
        // Arrange
        List<Server> servers = new ArrayList<>();

        // Act
        DataCenter dataCenter = new DataCenter();

        // Assert
        Assertions.assertEquals(dataCenter.servers(), servers, "The server lists must be equal because both are empty");
    }
}
