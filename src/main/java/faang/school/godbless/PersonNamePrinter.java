package faang.school.godbless;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PersonNamePrinter implements Runnable{
    private int startLimit;
    private int endLimit;
    @Override
    public void run() {
        for (int i = startLimit; i < endLimit; i++) {
            System.out.println("Name person: " + i);
        }
    }
}
