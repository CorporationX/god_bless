package faang.school.godbless;

//Создать класс Example. В нём объявить метод,
// который принимает массив целых чисел в качестве параметра
// и называется reverse. Этот метод должен разворачивать переданный массив.
// ример: {{nums = [1,2,3,4,5] }}→ reverse(nums) → nums = [5,4,3,2,1].

public class Example {
    public static int[] reverse(int[] toReverse) {
        int[] reversed = new int[toReverse.length];
        int j = 0;
        for(int i=reversed.length-1;i>=0;i--) {
            reversed[j]=toReverse[i];
            j++;
        }
        return reversed;
    }
}

