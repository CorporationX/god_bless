package school.faang.JavaBasic.BJS2_31414;
import static school.faang.JavaBasic.BJS2_31414.Example.reverse;

public class Main {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6};

        for (int i : array) {
            System.out.print(i + " ");
        }

        int[] reverseArray = reverse(array);


        System.out.println();
        for (int i : reverseArray) {
            System.out.print(i + " ");
        }
    }
}
