package faang.school.godbless.Task11_Double_Cache;
import lombok.Getter;

@Getter
public class Subject {
    private int id;
    private String name;

    public Subject(int id, String name) {
        if (id<1 || name.isBlank()) throw new IllegalArgumentException("mistake!");
        else {
            this.id = id;
            this.name = name;
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
