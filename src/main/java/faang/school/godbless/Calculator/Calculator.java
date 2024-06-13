package faang.school.godbless.Calculator;

public interface Calculator <T extends Integer> {
   T calculating(T numberOne, T numberTwo);
}