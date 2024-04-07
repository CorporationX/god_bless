package faang.school.godbless.thegameofthrone;

import lombok.Data;
import lombok.NonNull;

@Data
public class House {
    @NonNull
    private String name;
    @NonNull
    private String sigil;
}