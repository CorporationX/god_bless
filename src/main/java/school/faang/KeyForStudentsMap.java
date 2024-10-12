package school.faang;

import lombok.Data;

import java.util.Objects;
@Data
public class KeyForStudentsMap {
    private String faculty;
    private int year;

    public KeyForStudentsMap(int year, String faculty) {
        this.year = year;
        this.faculty = faculty;
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculty, year);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        KeyForStudentsMap key = (KeyForStudentsMap) obj;
        return year == key.year &&
                Objects.equals(faculty, key.faculty);
    }
}
