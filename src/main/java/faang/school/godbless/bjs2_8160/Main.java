package faang.school.godbless.bjs2_8160;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

  private static final List<Student> students = new ArrayList<>();

  public static void main(String[] args) {
    students.addAll(List.of(
        new Student("Петя", "Повт", 5),
        new Student("Вася", "мат.", 1),
        new Student("Марина", "мат.", 1),
        new Student("Света", "мат.", 3),
        new Student("Паша", "био.", 4),
        new Student("Дима", "Повт", 5)
    ));

    Map<CompoundKey, List<Student>> groupingStudents = getGroupingStudents(students);

    addStudent(groupingStudents, new Student("Нина", "Повт.", 5));
    addStudent(groupingStudents, new Student("Саша", "био.", 4));
    addNewStudent(groupingStudents, new Student("Ника", "мед.", 3));
    addStudent(groupingStudents, new Student("Коля", "мед.", 3));
    addStudent(groupingStudents, new Student("Саша", "мед.", 3));
    removeStudent(groupingStudents, new Student("Саша", "мед.", 3));
    searchStudent(groupingStudents, new CompoundKey("мед.", 3));
    showAllStudents(groupingStudents);

  }

  /**
   * Метод для группировки студентов по факультету и курсу.
   * @param students список студентов
   * @return сгруппированные студенты по факультету и курсу.
   */
  private static Map<CompoundKey, List<Student>> getGroupingStudents(List<Student> students) {
    return students
        .stream()
        .collect(Collectors.groupingBy(student -> new CompoundKey(student.faculty(), student.year()),
            Collectors.toList()));
  }

  /**
   * Добавление нового студента в список.
   * @param groupingStudents сгруппированные студенты по факультету и курсу.
   * @param student добавляемый студент.
   */
  private static void addStudent(Map<CompoundKey, List<Student>> groupingStudents, Student student) {
    groupingStudents.computeIfPresent(new CompoundKey(student.faculty(), student.year()), (key, value) -> {
      value.add(student);
      return value;
    });
  }

  /**
   * Добавления нового студента, если нет в группировке записи с факультетом и курсом добавляемого студента.
   * @param groupingStudents сгруппированные студенты по факультету и курсу.
   * @param student добавляемый студент.
   */
  private static void addNewStudent(Map<CompoundKey, List<Student>> groupingStudents, Student student) {
    groupingStudents.computeIfAbsent(new CompoundKey(student.faculty(), student.year()),
        value -> new ArrayList<>(List.of(student)));
  }

  /**
   * Удаление студента из списка по его имени, факультету и курсу.
   * @param groupingStudents сгруппированные студенты по факультету и курсу.
   * @param student
   */
  private static void removeStudent(Map<CompoundKey, List<Student>> groupingStudents, Student student) {
    groupingStudents.computeIfPresent(new CompoundKey(student.faculty(), student.year()), (key, value) -> {
      value.remove(student);
      return value;
    });
  }

  /**
   * Поиск всех студентов определённого факультета и курса
   * @param groupingStudents сгруппированные студенты по факультету и курсу.
   * @param key составной ключ для поиска.
   */
  private static void searchStudent(Map<CompoundKey, List<Student>> groupingStudents, CompoundKey key) {
    System.out.println(groupingStudents.get(key));
  }

  /**
   * Вывод списка всех студентов сгруппированных по факультетам и курсам.
   * @param groupingStudents сгруппированные студенты по факультету и курсу.
   */
  private static void showAllStudents(Map<CompoundKey, List<Student>> groupingStudents) {
    groupingStudents.forEach((key, value) -> System.out.println(key + " - " + value));
  }

}
