package school.faang.HashMaps.doubleCache;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
    private String name;
    private int id;

    @Override
    public String toString() {
        return "Student: " +
                "name='" + name + '\'' +
                ", id=" + id;
    }
}
