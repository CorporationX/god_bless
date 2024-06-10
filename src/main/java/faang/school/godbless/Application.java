package faang.school.godbless;


public class Application {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5};

        Reverse.reverseArray(numbers);

        for (int number: numbers){
            System.out.println(number);
        }
    }

}