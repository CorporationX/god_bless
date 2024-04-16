package faang.school.godbless.ElectricDiary;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class StudentsToTableCollector implements Collector<Student, StringBuilder, String> {
    @Override
    public Supplier<StringBuilder> supplier() {
        return () -> {
            StringBuilder builder = new StringBuilder();
            builder.append(String.format("%-15s", "ФИО")).append("|");
            Arrays.stream(Course.values()).forEach(course -> builder.append(String.format("%-8s", course)).append("|"));
            builder.append(String.format("%-8s|%-10s" , "%", "Общая оценка"));
            return builder.append("\n");
        };
    }

    @Override
    public BiConsumer<StringBuilder, Student> accumulator() {
        return (builder, student) -> {
            Map<Course, Double> avgMarks = student.getAverageMarks();
            Course[] courses = Course.values();

            builder.append(String.format("%-15s", student.getFirstName() + " " +student.getLastName())).append("|");
            Arrays.stream(courses).forEach(course -> builder.append(String.format("%8.1f", avgMarks.get(course))).append("|"));

            double marksSum = avgMarks.values().stream().reduce(0.0, Double::sum);
            builder.append(String.format("%8.1f", marksSum / (courses.length * 5) * 100)).append("|");
            builder.append(String.format("%8.1f", marksSum / courses.length));

            builder.append("\n");
        };
    }

    @Override
    public BinaryOperator<StringBuilder> combiner() {
        return (first, second) -> first.append(second.toString());
    }

    @Override
    public Function<StringBuilder, String> finisher() {
        return StringBuilder::toString;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of(Collector.Characteristics.UNORDERED);
    }
}
