package faang.school.godbless.BJS2_20000;

import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Data
@Builder
public class Subject {
    private int id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subject subject)) return false;
        return getId() == subject.getId() && Objects.equals(getName(), subject.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
