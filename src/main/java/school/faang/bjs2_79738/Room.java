package school.faang.bjs2_79738;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Room {
    private int roomNumber;
    private String type;
    private final Set<String> amenities = new HashSet<>();
}
