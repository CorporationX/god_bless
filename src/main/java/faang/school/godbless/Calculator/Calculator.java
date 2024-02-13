package faang.school.godbless.Calculator;

@FunctionalInterface
public interface Calculator <T extends Number>{
     T calc(T number1, T number2);
}