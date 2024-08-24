package faang.school.godbless.army_of_heroes;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class Army {

    private List<Character> characterList = new ArrayList<>();

    public void addCharacter(Character character) {
        if (character == null) {
            System.out.println("Объект не может быть null!");
        } else {
            characterList.add(character);
        }
    }

    @SneakyThrows
    public int calculateTotalPower() {
        List<MyThread> threadList = new ArrayList<>();

        for (Character character : characterList) {
            MyThread myThread = new MyThread(character);
            myThread.start();
            System.out.println(myThread.getCharacter() + " запустился в потоке - " + myThread.getName());
            threadList.add(myThread);
            myThread.join();
        }

        return threadList.stream().mapToInt(MyThread::getSumPower).sum();
    }
}
