package faang.school.godbless.BJS2_4335;

public class Example {
    public static void main(String[] args){
        int[] numbers = {1, 2, 3, 4, 5};
        int[] reversedNumbers = reverse(numbers);

        for (int numb : reversedNumbers) {
            System.out.println(numb);
        }
    }

    public static int[] reverse(int[] numbers){
        int buf;
        for (int i = 0; i < numbers.length/2; i++){
            buf = numbers[i];
            numbers[i] = numbers[numbers.length-i-1];
            numbers[numbers.length-i-1] = buf;
        }
        return numbers;
    }
}

