package faang.school.godbless;

public class Application {
    public static void main(String... args) {
        int[] numbers = new int[]{1, 3, 4, 5, 6, 7,8};
        numbers = new Example().reverse(numbers);
        for(int number : numbers){
            System.out.print(number + " ");
        }
    }
}
