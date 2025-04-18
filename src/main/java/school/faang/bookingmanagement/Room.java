package school.faang.bookingmanagement;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@RequiredArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "roomNumber")
public class Room {
    private final int roomNumber;
    private String type;
    private Set<String> amenities;
}
