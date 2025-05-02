package school.faang.sprint4_future_async.thetriwizardtournament;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Data
@AllArgsConstructor
public class School {
    private String name;
    private CopyOnWriteArrayList<Student> students;

    public School(String name, List<Student> students) {
        this.name = name;
        this.students = new CopyOnWriteArrayList<>(students);
    }

    public int getTotalPoints() {
        return students.stream()
                .mapToInt(st -> st.getPoints().get())
                .sum();
    }
}