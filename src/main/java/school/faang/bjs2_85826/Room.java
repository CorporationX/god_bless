package school.faang.bjs2_85826;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Room {
    private final int roomNumber;
    private final String type;
    private final Set<String> amenities;
}
