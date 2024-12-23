package school.faang.bjs_49275;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class VideoManagerServiceTest {

    @Test
    void startService() {
        VideoManagerService service = new VideoManagerService();
        Assertions.assertDoesNotThrow(service::startService);
    }
}