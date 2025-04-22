package school.faang.stream3.googlephotosync;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UploadService {
    public static void sendToCloud(String fileName) {
        log.info(String.format("Sending %s fileName to the cloud", fileName));
    }
}
