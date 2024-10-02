package school.faang.t05;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] num = {1,2,3,4,5};
        System.out.println(Arrays.toString(num));
        Example.reverse(num);
        System.out.println(Arrays.toString(num));

    }
}