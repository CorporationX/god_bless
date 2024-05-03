package faang.school.godbless.electronic_diary;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class StudentCollector implements Collector<Student, StringBuilder, String> {

    private final NumberFormat FORMATTER = new DecimalFormat("#0.00");

    public static StudentCollector printInfoAboutEachStudent() {
        return new StudentCollector();
    }

    @Override
    public Supplier<StringBuilder> supplier() {
        return () -> {
            StringBuilder builder = new StringBuilder();
            builder.append(String.format("%-20s", "ФИО")).append("|");
            Arrays.stream(CourseType.values()).forEach(course -> builder.append(String.format("%-12s", course.name())).append("|"));
            builder.append("Общая оценка").append("\n");
            return builder;
        };
    }

    @Override
    public BiConsumer<StringBuilder, Student> accumulator() {
        return (builder, student) -> {
            builder.append(String.format("%-20s", student.getFirstName() + " " + student.getLastName())).append("|");
            final double[] totalMark = {0.0};
            Arrays.stream(CourseType.values())
                    .forEach(course -> {
                        Double toAppend = student.getAvgMarkBySubject(course);
                        totalMark[0] += toAppend;
                        if (toAppend == 0.0) {
                            builder.append(String.format("%-12s", "")).append("|");
                        } else {
                            builder.append(String.format("%-12s", toAppend)).append("|");
                        }
                    });
            builder.append(FORMATTER.format(totalMark[0] / student.getCourses().size()).replace(",", "."));
            builder.append("\n");
        };
    }

    @Override
    public BinaryOperator<StringBuilder> combiner() {
        return null;
    }

    @Override
    public Function<StringBuilder, String> finisher() {
        return (builder) -> {
            System.out.println(builder.toString());
            return builder.toString();
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of(Characteristics.UNORDERED);
    }
}