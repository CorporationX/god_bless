package school.faang.instagram_filters.BJS2_57744;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
public class Image {
    private static final Logger LOGGER = LoggerFactory.getLogger(Image.class);

    private final String name;
    @Setter
    private String description;

    public Image(String name, String description) {
        validateString(name, "Name is null or blank", "Name cannot be null or blank");
        validateString(description, "Description is null or blank", "Description cannot be null or blank");

        this.name = name;
        this.description = description;

        LOGGER.info("Image created");
    }

    private static void validateString(String value, String errorMessage, String exceptionMessage) {
        if (value == null || value.isBlank()) {
            LOGGER.error("Validation failed: {}", errorMessage);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }
}
