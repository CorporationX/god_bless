package faang.school.godbless;

public interface Calculator <T extends Integer> {
   T calculating(T numberOne, T numberTwo);
}