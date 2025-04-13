package hotels;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

import java.util.Set;

@Getter
public class Room {
    @NonNull
    private Integer roomNumber;
    private String type;
    private Set<String> amenities;


}
