package school.faang.bjs246554;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record Image(String fileName, String description) {

    public Image {
        if (fileName == null || fileName.trim().isEmpty() || description == null || description.trim().isEmpty()) {
            log.error("File name or description is invalid.");
            throw new IllegalArgumentException("File name or description cannot be null or empty.");
        }
    }
}