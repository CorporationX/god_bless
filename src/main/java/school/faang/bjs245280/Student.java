package school.faang.bjs245280;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class Student {
    private int id;
    @NonNull
    private String name;
    public String toString() {
        return this.name;
    }
}
