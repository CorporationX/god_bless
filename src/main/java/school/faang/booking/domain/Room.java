package school.faang.booking.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Danil Pudovkin
 * @since 09.06.2025
 */
@Data
@ToString(of = {"number", "type"})
@EqualsAndHashCode(of = {"number", "type"})
public class Room {

    private final int number;
    private final String type;
    private final Set<String> amenities = new HashSet<>();
}
