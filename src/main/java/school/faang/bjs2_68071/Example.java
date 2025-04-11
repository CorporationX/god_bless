package school.faang.bjs2_68071;

class Example {
    private Example() {
        //для предотвращения создание экземпляра класса
    }

    public static int[] reverse(int[] array) {
        int head = 0;
        int tail = array.length - 1;
        while (head < tail) {
            int temp = array[head];
            array[head] = array[tail];
            array[tail] = temp;
            head++;
            tail--;
        }
        return array;
    }
}
