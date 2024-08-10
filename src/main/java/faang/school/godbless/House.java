package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class House {
    private String name;
    private String sigil;

    @Override
    public String toString() {
        return "House: " + name + " sigil: " + sigil;
    }
}
