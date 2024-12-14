package school.faang.sprint_2.task_47303;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class SchoolService {
    @NonNull
    private final List<Student> students;

    public void add(@NonNull Student student) {
        students.add(student);
    }

    public void remove(@NonNull Student student) {
        students.remove(student);
    }

    public List<Student> getStudents() {
        return List.copyOf(students);
    }

    //По хорошему этот метод должен вызывать юзер, и возвращать стоит лист подходящих студентов,
    // а юзер будет выбирать какой именно ему нужен, ну или добавить id студентам
    // но по условию задачи это не прописано, поэтому так
    public Student getStudentByFirstAndLastName(@NonNull String firstName, @NonNull String lastName) {
        return students.stream()
                .filter(student -> student.getFirstName().equals(firstName)
                        && student.getLastName().equals(lastName))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public Map<String, Double> getAverageGrades() {
        return students.stream()
                .flatMap(student -> student.getSubjects().entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.flatMapping(
                                entry -> entry.getValue().stream(),
                                Collectors.averagingDouble(Integer::doubleValue)
                        )
                ));
    }

    //Решил поменять на сразу на student, если где-то нужно, могут сначала получить студента соответствующим методом
    public Map<String, Integer> getStudentFinalGrades(@NonNull Student student) {
        return student.getSubjects()
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> (int) Math.round(entry.getValue()
                                .stream()
                                .mapToInt(Integer::intValue)
                                .average()
                                .orElse(0))));
    }

    public String getHardestSubject() {
        return getAverageGrades().entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElseThrow(NoSuchElementException::new);
    }

    public void printStudents() {
        List<String> allSubjects = getSubjects();

        StringBuilder header = new StringBuilder(String.format("%-" + getMaxNameLength() + "s", "ФИО"));
        allSubjects.forEach(subject -> header.append(String.format("| %-" + subject.length() + "s", subject)));
        header.append(String.format("| %6s| %-18s", "%", "Итоговая оценка"));
        System.out.println(header);

        for (Student student : students) {
            StringBuilder studentRow = new StringBuilder(String.format("%-" + getMaxNameLength() + "s",
                    student.getFirstName() + " " + student.getLastName()));
            double totalGrades = 0;
            int amountOfSubjects = 0;
            Map<String, Integer> studentFinalGrades = getStudentFinalGrades(student);

            for (String subject : allSubjects) {
                Integer subjectFinalGrade = studentFinalGrades.get(subject);
                String formatSupport = "| %";
                if (subjectFinalGrade != null) {
                    studentRow.append(String.format(formatSupport + (subject.length() - 1) + "d ", subjectFinalGrade));
                    totalGrades += subjectFinalGrade;
                    amountOfSubjects++;
                } else {
                    studentRow.append(String.format(formatSupport + (subject.length() - 1) + "s ", "-"));
                }

            }

            double finalGrade = totalGrades / amountOfSubjects;
            double percentage = finalGrade / 5 * 100;

            studentRow.append(String.format("| %-6.2f| %-18.1f", percentage, finalGrade));

            System.out.println(studentRow);
        }
    }

    private int getMaxNameLength() {
        return students.stream()
                .mapToInt(student -> student.getFirstName().length() + student.getLastName().length() + 1)
                .max()
                .orElseThrow(() -> new UnsupportedOperationException("students list is empty"));
    }

    private List<String> getSubjects() {
        return students.stream()
                .flatMap(student -> student.getSubjects().keySet().stream())
                .distinct()
                .toList();
    }
}
