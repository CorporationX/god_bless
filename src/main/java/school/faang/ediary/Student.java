package school.faang.ediary;

import lombok.Getter;
import lombok.Setter;
import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
public class Student {
    private String firstName;
    private String lastName;
    private Map<String, List<Integer>> courses;

    public Student(String firstName, String lastName,
                   Map<String, List<Integer>> courses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = courses;
    }

    public static Map<String, Double> calculateAverageGrade(
            List<Student> students) {
        return students
                .stream()
                .map(Student::getCourses)
                .map(Map::entrySet)
                .flatMap(x -> x.stream())
                .collect(Collectors.groupingBy(x -> x.getKey()))

                .entrySet()
                .stream()
                .map(x -> {
                    String subject = x.getKey();
                    List<Integer> listOfAllGradesForTheSubject =
                            new ArrayList<>();
                    List<Map.Entry<String, List<Integer>>> listOfEntries
                            = x.getValue();

                    for (Map.Entry<String, List<Integer>> e : listOfEntries) {
                        List<Integer> listOfGradesforThisStudent =
                                e.getValue();
                        listOfAllGradesForTheSubject.addAll(
                                listOfGradesforThisStudent);
                    }
                    Map.Entry<String,List<Integer>> entry = new AbstractMap
                            .SimpleEntry<>(subject, listOfAllGradesForTheSubject);
                    return entry;
                })
                .collect(
                        Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))

                .entrySet()
                .stream()
                .map(x -> {
                    String subject = x.getKey();
                    List<Integer> grades = x.getValue();
                    int sum = 0;

                    for (int i = 0; i < grades.size(); i++) {
                        sum += grades.get(i);
                    }
                    double averageGrade = sum / grades.size();

                    Map.Entry<String,Double> average = new AbstractMap
                            .SimpleEntry<>(subject, averageGrade);
                    return average;
                })
                .collect(
                        Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static Map<String, Integer> getFinalGradesForStudent(
            List<Student> students, String firstName, String lastName)
            throws NoSuchElementException {

        Map<String, Integer> result = students
                .stream()
                .filter(x -> x.getFirstName().equals(firstName) &&
                        x.getLastName().equals(lastName))
                .findFirst()
                .get()
                .getCourses()
                .entrySet()
                .stream()
                .map(x -> {
                    String subject = x.getKey();
                    List<Integer> grades = x.getValue();
                    int sum = 0;

                    for (int i=0; i< grades.size(); i++) {
                        sum += i;
                    }
                    int averageGrade = sum / grades.size();

                    Map.Entry<String,Integer> average = new AbstractMap
                            .SimpleEntry<>(subject, averageGrade);
                    return average;
                })
                .collect(
                        Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return result;
    }

    public static String findMostDifficultSubject(List<Student> students)
            throws NoSuchElementException {
        String result = null;

        class MapComparator
                implements Comparator<Map.Entry<String, Double>>  {
            public int compare(Map.Entry<String, Double> a,
                               Map.Entry<String, Double> b) {
                return a.getValue().compareTo(b.getValue());
            }
        }

        MapComparator mapComparator = new MapComparator();

        boolean equalityOfAll = calculateAverageGrade(students)
                .entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .distinct()
                .count() <= 1;

        Map.Entry<String, Double> resultEntry = calculateAverageGrade(students)
                .entrySet()
                .stream()
                .min(mapComparator)
                .get();

        String subjectName = resultEntry.getKey();
        Double gradeOfThisSubject = resultEntry.getValue();

        if (!equalityOfAll) {
            result = subjectName;
        } else if (gradeOfThisSubject >= 4.0) {
            result = "В нашей шараге нет трудных предметов";
        } else {
            result = "У нас все предметы одинаково трудные! " +
                    "Это пятьдесят седьмая школа, чувак!";
        }

        return result;
    }

}
