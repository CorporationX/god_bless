import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = Calcmethod.sum(nums);
        int product = Calcmethod.product(nums);
        System.out.println(sum);
        System.out.println(product);
    }
}