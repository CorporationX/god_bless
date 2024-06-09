package faang.school.godbless.vesteros;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = {"name", "sigil"})
@ToString
public class House {
    private String name;
    private String sigil;


}
