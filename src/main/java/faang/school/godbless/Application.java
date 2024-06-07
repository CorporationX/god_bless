package faang.school.godbless;

import static faang.school.godbless.Example.reverse;

public class Application {
    public static void main(String[] args) {
        int nums[] = {1, 4, 6, 7};
        int resultNums[];

        resultNums = reverse(nums);
        System.out.print("Массив: ");
        for(int i = 0; i < resultNums.length; i++){
            System.out.print(resultNums[i] + " ");
        }
    }
}