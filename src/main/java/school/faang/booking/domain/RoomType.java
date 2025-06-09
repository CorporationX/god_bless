package school.faang.booking.domain;

import lombok.RequiredArgsConstructor;

/**
 * @author Danil Pudovkin
 * @since 09.06.2025
 */
@RequiredArgsConstructor
public enum RoomType {
    CONFERENCE("Конференц-зал"),
    MEETING("Переговорная"),
    RECEPTION("Приёмная");

    private final String value;
}
