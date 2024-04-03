package faang.school.godbless.BJS2_4335;

public class Example {
    public static void main(String[] argc){
        int[] numbs = {1, 2, 3, 4, 5};
        int[] finalArray = reverse(numbs);

        for (int numb : finalArray) {
            System.out.println(numb);
        }
    }

    public static int[] reverse(int[] numbs){
        int arraySize = numbs.length;
        int[] reverseOfNumbs = new int[arraySize];

        for(int i = 0; i < arraySize; i++){
            reverseOfNumbs[i] = numbs[(arraySize-1)-i];
        }

        return reverseOfNumbs;
    }
}
