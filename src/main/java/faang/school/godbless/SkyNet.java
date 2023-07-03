package faang.school.godbless;

public class SkyNet extends Thread{
    public static void main(String[] args) {
        Robot terminator = new Robot("Terminator" ,"SuperMan");
        Robot ironMan = new Robot("IronMan" ,"SuperMan");

        Thread thread1 = new Thread(terminator::attack);
        Thread thread2 = new Thread(ironMan::attack);

        thread1.start();
        thread2.start();
    }
}
