package faang.school.godbless.Task11_Double_Cache;
import lombok.Getter;

@Getter
public class Student {

    private int id;
    private String name;

    public Student(int id, String name) {
        if (name.isBlank() || id < 1) throw new IllegalArgumentException("invalid input");
        else {
            this.id=id;
            this.name=name;
        }
    }

    @Override
    public String toString() {
        return name;
    }

}
