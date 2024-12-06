package school.faang.bjs243520;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Book {

    private String title;
    private String author;
    private int Year;

    @Override
    public boolean equals(Object o) {

        return true;
    }

    @Override
    public int hashCode() {

        return 0;
    }
}
