package school.faang.bjs_49275;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class VideoManagerServiceTest {

    @Test
    void startService() {
        VideoManagerService service = new VideoManagerService();
        List<String> videos = List.of(
                "Video #1",
                "Video #2",
                "Video #3",
                "Video #4",
                "Video #5",
                "Video #6",
                "Video #7",
                "Video #8",
                "Video #9",
                "Video #10"
        );
        service.startService(videos);
        int actual = service.getViewCount(videos);
        int expected = 100;
        Assertions.assertEquals(expected, actual);
    }
}