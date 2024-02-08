package faang.school.godbless;

import java.util.Arrays;

public class Example {
    public static void reverse(int[] num) {
        int l=num.length;
        for (int i = 0; i < l/2; i++) {
            int tmp=num[i];
            num[i]= num[l-i-1];
            num[l-i-1]=tmp;
        }
    }
    public static void main(String[] args) {
        int[] array = {5, 2, 3, 8, 6, 4, 54, 80, 98};
        reverse(array);
        System.out.println(Arrays.toString(array));
    }
}


