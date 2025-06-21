package school.faang.diary;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * @author Danil Pudovkin
 * @since 20.06.2025
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"firstName", "lastName"})
@EqualsAndHashCode(of = {"firstName", "lastName"})
public class Student implements Comparable<Student> {

    private String firstName;
    private String lastName;
    private Map<String, List<Integer>> subjects;

    @Override
    public int compareTo(Student o) {
        return Comparator.comparing(Student::getFirstName, Comparator.nullsLast(String::compareTo))
                .thenComparing(Student::getLastName, Comparator.nullsLast(String::compareTo))
                .compare(this, o);
    }
}
