package school.faang.booking.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Danil Pudovkin
 * @since 09.06.2025
 */
@Getter
@RequiredArgsConstructor
public enum AmenityType {
    PROJECTOR("Проектор"),
    VIDEO_CONFERENCE("Видеоконференция");

    private final String value;
}
