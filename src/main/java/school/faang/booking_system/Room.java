package school.faang.booking_system;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.Set;

@AllArgsConstructor
@Getter
public class Room {
    private Integer roomNumber;
    private String type;
    private Set<String> amenities;
}
