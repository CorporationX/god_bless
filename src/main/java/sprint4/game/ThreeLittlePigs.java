package sprint4.game;

import sprint4.game.workers.Pig1Thread;
import sprint4.game.workers.Pig2Thread;
import sprint4.game.workers.Pig3Thread;

import java.util.List;

public class ThreeLittlePigs {
    private static final List<Thread> THREAD_POOL = List.of(
            new Pig1Thread("���-���"),
            new Pig2Thread("���-���"),
            new Pig3Thread("���-���")
    );

    public static void main(String[] args) {
        for (Thread thread : THREAD_POOL) {
            thread.start();
        }

        for (Thread thread : THREAD_POOL) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.printf("����� %s ��� �������� ��������������\n", thread.getName());
            }
        }
        System.out.println("���� ���������!");
    }
}
