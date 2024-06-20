package faang.school.godbless.multithreading.tournament;

public record Trial(String knigthName, String trialName) implements Runnable {

    @Override
    public void run(){
        System.out.println("Рыцарь " + knigthName + " начал проходить испытание " + trialName);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Рыцарь " + knigthName + " закончил проходить испытание " + trialName);
    }
}
