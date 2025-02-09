package school.faang.doublecache;

import java.util.Objects;

public record Student(String name) {

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
