package school.faang.Module1.Booking_organization_system;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import java.util.Set;

@Getter
@AllArgsConstructor // Генерирует конструктор со всеми полями
@ToString // Генерирует метод toString()

public class Room {
    private int roomNumber;
    private String roomType;
    private Set<String> roomAmenities;
}