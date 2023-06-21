package faang.school.godbless.sprint3.task5;

public class RemoteService {

    public static boolean call(int number) {
        switch (number) {
            case 0:
                return false;
            case 1:
                return true;
            default:
                throw new IllegalArgumentException();
        }
    }
}
