package hashmap.got;

import lombok.Data;
import lombok.NonNull;

@Data
public class House {
    @NonNull
    private final String name;
    @NonNull
    private final String sigil;
}
