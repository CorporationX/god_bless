package school.faang.booking.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Danil Pudovkin
 * @since 09.06.2025
 */
@Getter
@RequiredArgsConstructor
public enum RoomType {
    CONFERENCE("Конференц-зал"),
    MEETING("Переговорная"),
    RECEPTION("Приёмная");

    private final String value;
}
