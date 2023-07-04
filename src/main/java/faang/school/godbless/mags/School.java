package faang.school.godbless.mags;

import java.util.List;

public class School {
  private String name;
  private List<Student> students;

  public School(String name, List<Student> students) {
    this.name = name;
    this.students = students;
  }

  public int getTotalPoints() {
    return students.stream()
        .mapToInt(Student::getPoints)
        .reduce(0, Integer::sum);
  }

  public List<Student> getStudents() {
    return students;
  }

  public String getName() {
    return name;
  }
}
