package school.faang.task_45395;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Subject {
    private int id;
    private String name;

    public Subject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Subject{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
