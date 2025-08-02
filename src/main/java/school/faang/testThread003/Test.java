package school.faang.testThread003;

public class Test implements Runnable {

    public void run() {
        for (int i = 0; i < 10; i++) {
            // System.out.println("q >> " + Thread.currentThread().getName());
            synchronized (this) {
                String x = "Hello";
                String y = "World";
                System.out.println(x + ' ' + y + ' ' + Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        Test run = new Test();
        Thread obj1 = new Thread(run);
        Thread obj2 = new Thread(run);
        obj1.start();
        obj2.start();
    }
}
