package hotels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import java.util.Set;

@AllArgsConstructor
@EqualsAndHashCode
@Data
public class Room {
    @NonNull
    private Integer roomNumber;
    private String type;
    private Set<String> amenities;


}
