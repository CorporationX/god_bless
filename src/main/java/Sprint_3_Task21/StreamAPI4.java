package Sprint_3_Task21;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAPI4 {

    public static Map<String, Double> schoolAverage(List<Student> students){
        // Средняя оценка за предмет считается по формуле:
        // сумма оценок по данному предмету у всех учеников, поделённая на количество оценок;
        return students.stream()
                .flatMap(student -> student.getCourses().entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.flatMapping(x -> x.getValue().stream(),
                                Collectors.averagingDouble(x -> x))));

    }
    public static Map<String, Long> studentIsFinalGrade(List<Student> students, String lastName, String firstName){
        //Посчитать итоговую оценку по каждому предмету для конкретного ученика. На вход получаем список учеников.
        // И имя и фамилию ученика, возвращаем Map<String, Integer>, где ключ — название предмета, значение — оценка по предмету.
        // Округляем к ближайшему целому числу.
        // Класс Math выручит здесь;
        return students.stream()
                .filter(student -> student.getLastName().equals(lastName) && student.getFirstName().equals(firstName))
                .flatMap(student -> student.getCourses().entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> Math.round(entry.getValue().stream().mapToInt(Integer::intValue).average().orElse(0))));

    }
    public static String ItemName(List<Student> students){
        //Найти предмет, и вернуть его название.
        // Предмет, который оказался самым сложным для всех учеников, то есть по которому средняя оценка ниже,
        // чем по всем остальным предметам.
        // Например, по Математике средняя успеваемость всех учеников 4.2, а вот по Химии 3.8.
        // Соответственно Химия считается более сложным предметом, чем Математика.
        // Метод принимает список учеников и находит такой предмет среди них всех.
        return students.stream()
                .flatMap(x -> x.getCourses().entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.flatMapping(x -> x.getValue().stream(),
                                Collectors.averagingDouble(x -> x)))).entrySet().stream()
                .sorted((x1, x2) -> (int) ((x1.getValue() * 100) - (x2.getValue() * 100)))
                .map(Map.Entry::getKey)
                .toList()
                .get(0);
    }

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("John", "Doe",
                        Map.of("Java", List.of(5, 4, 4), "Python", List.of(3, 4, 3), "C++", List.of(3, 3, 3))),
                new Student("Jane", "Doe",
                        Map.of("Java", List.of(4, 3, 3), "Python", List.of(4, 5, 5), "C++", List.of(5, 5, 5))),
                new Student("Jack", "Doe",
                        Map.of("Java", List.of(4, 5, 4), "Python", List.of(4, 3, 4), "C++", List.of(5, 5, 4)))
        );
        String lastName = "Doe";
        String firstName = "John";
        String firstName1 = "Jack";
        String firstName2 = "Jane";
        System.out.println(schoolAverage(students));
        System.out.println(studentIsFinalGrade(students, lastName, firstName));
        System.out.println(ItemName(students));
    }
}
