package school.faang.s_4_1_triwizard_tournament;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class School {
    private String name;
    private final List<Student> team = new CopyOnWriteArrayList<>();
//    private final List<Student> team = Collections.synchronizedList(new ArrayList<>());
//    private final List<Student> team = new ArrayList<>();

    public School(String name) {
        this.name = name;
    }

    public List<Student> getTeam() {
        return team;
//        return new ArrayList<>(team);
    }

    public String getName() {
        return name;
    }

    public void addStudent(Student student) {
        this.team.add(student);
    }

    public int getTotalPoints() {
        return team.stream()
                .mapToInt(Student::getPoints)
                .sum();
    }
}
