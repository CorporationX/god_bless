package first_task;

import static first_task.Example.printArray;
import static first_task.Example.reverse;

public class Main {
    public static void main(String[] args) {
        int[] testArray1 = {1, 2, 3, 4, 5};
        System.out.println("Массив до ревёрса: ");
        printArray(testArray1);
        reverse(testArray1);

        System.out.println("Массив после ревёрса");
        printArray(testArray1);
    }
}
