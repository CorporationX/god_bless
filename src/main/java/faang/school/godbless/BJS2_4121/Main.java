package faang.school.godbless.BJS2_4121;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> arrayCollection = List.of(1, 2, 3, 4, 5);
        List<Integer> reversedArrayCollection = ExampleCollection.reverse(arrayCollection);

        System.out.println(arrayCollection);
        System.out.println(reversedArrayCollection);
        System.out.println(arrayCollection);

        int[] array = {1, 2, 3, 4, 5};
        int[] reversedArray = ExampleArray.reverse(array);

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(reversedArray));
        System.out.println(Arrays.toString(array));

        int[] arrayIndicator = {1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(arrayIndicator));
        System.out.println(Arrays.toString(ExampleIndicator.reverse(arrayIndicator)));
        System.out.println(Arrays.toString(arrayIndicator));
    }
}
