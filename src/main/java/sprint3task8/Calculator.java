package sprint3task8;

@FunctionalInterface
public interface Calculator<U, R> {
    R calculate(U p1, U p2);

    void calculate(Integer num);
}
   // public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException
