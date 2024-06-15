package faang.school.godbless.reverse;



public class Example {
    public int[] reveverse(int[] arrays) {
        int[] rev = new int[arrays.length];
        for (int i = 0; i < arrays.length; i++) {
            rev[i] = arrays[arrays.length - 1 - i];
        }
        return rev;
    }
}






