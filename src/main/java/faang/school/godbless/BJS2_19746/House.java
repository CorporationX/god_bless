package faang.school.godbless.BJS2_19746;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class House {
    private String name;
    private String sigil;

    @Override
    public String toString() {
        return String.format("House name: %s, Sigil: %s", name, sigil);
    }
}
