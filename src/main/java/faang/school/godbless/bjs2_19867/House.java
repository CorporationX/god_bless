package faang.school.godbless.bjs2_19867;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
public class House {
    private String name;
    private String sigil;

    @Override
    public String toString() {
        return "Name: " + name + "; Sigil: " + sigil;
    }
}
