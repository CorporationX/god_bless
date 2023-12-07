package faang.school.godbless.Turn_around;

public class Example {
    public static void reverse(int[] array){
        int d=0;
        for (int i = 0; i < array.length; i++) {
            array[i]=array.length-d;
            d++;
        }
        for(int a:array){
            System.out.println(a);
        }
    }
}
