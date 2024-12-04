package school.faang.task_43939;


public class Utilities {

    public static int getRandomIntegerWithinRange(int min, int max) {
        return min + (int) (Math.random() * (max - min + 1));
    }
}
