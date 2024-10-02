package faang.school.godbless;

public class Example {
    int[] reverse(int e[]) {
        int e1[] = new int[e.length];
        for (int i = e.length - 1, i1 = 0; i >= 0; i--, i1++) {
            e1[i1] = e[i];
        }
        for (int i : e1)
            System.out.println(i);
        return e1;
    }

    public static void main(String[] args) {
        Example d = new Example();
        System.out.println(d.reverse(new int[]{1, 2, 3, 4, 5}));
        System.out.println(d.reverse(new int[]{23, -17, 85,32, 7444}));
    }
}
