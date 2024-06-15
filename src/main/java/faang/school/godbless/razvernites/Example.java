package faang.school.godbless.razvernites;
class Example {
    static void reverse(int[] massiv) {
        int count = 0;
        int[] numNew = new int[massiv.length];
        for (int i = 0; i < massiv.length; i++) {
            int numberMassiv = 0;
            numberMassiv = massiv[(massiv.length - 1 - count)];
            count++;
            int countIndexnumNew =0;
            numNew[countIndexnumNew]=numberMassiv;
            countIndexnumNew++;
            System.out.println(numberMassiv);
        }

    }
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5, 6, 7};
        reverse(num);

    }
}