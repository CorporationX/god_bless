package three.mags;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Getter
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> students;

    public int getTotalPoints() {
        if (Objects.isNull(students) || students.isEmpty()) {
            log.error("Students list in school {} is null or empty!", name);
            throw new IllegalArgumentException();
        }
        return students.stream().map(Student::getPoints).mapToInt(AtomicInteger::get).sum();
    }
}
