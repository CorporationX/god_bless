package Reverse;

public class Example {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        reverse(nums);
    }

    public static void reverse(int[] num){
        int middle; //для возможности использования любого массива, а не только заданного
        if (num.length % 2 == 0) {
            middle = num.length / 2;
        }
        else {
            middle = num.length / 2 + 1;
        }

        for (int i = 0; i < num.length; i++) {

            if ( i < middle) {
                int itterFirst = num[i];
                int itterAnd = num.length - i - 1;
                int andNum = num.length - i;

                num[i] = andNum;
                num[itterAnd] = itterFirst;

            }
        }

        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
    }
}

