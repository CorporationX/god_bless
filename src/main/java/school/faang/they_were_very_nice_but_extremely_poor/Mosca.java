package school.faang.they_were_very_nice_but_extremely_poor;

import lombok.Getter;

class Mosca {
    public static void main(String[] args) throws InterruptedException {
        int[] a = {4, 4, 4, 5, 6, 7, 8, 9, 0};
        int[] b = {0, -1, -2, -3, -4, -5, -6, -7, -8, -9};

        MinFinder minFinder = new MinFinder(a);
        MaxFinder maxFinder = new MaxFinder(b);

        minFinder.start();
        maxFinder.start();

        minFinder.join();
        maxFinder.join();

        System.out.println("Max: " + maxFinder.getResult());
        System.out.println("Min: " + minFinder.getResult());
    }

    static class MinFinder extends Thread {
        private final int[] array;
        @Getter
        private int result;

        MinFinder(int[] array) { this.array = array; }

        public void run() {
            result = array[0];
            for (int num : array) if (num < result) result = num;
        }

    }

    static class MaxFinder extends Thread {
        private final int[] array;
        @Getter
        private int result;

        MaxFinder(int[] array) { this.array = array; }

        public void run() {
            result = array[0];
            for (int num : array) if (num > result) result = num;
        }

    }
}