package school.faang.task_45277;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Subject {
    private UUID id;
    private String name;

    public Subject(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (!(o instanceof Subject)){
            return false;
        }
        Subject subject = (Subject) o;
        return id.equals(subject.id) && name.equals(subject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}