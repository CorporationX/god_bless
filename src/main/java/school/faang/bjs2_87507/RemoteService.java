package school.faang.bjs2_87507;

public class RemoteService {
    private RemoteService() {}

    public static String call(int usersCount) {
        if (usersCount >= 0 && usersCount < 2) {
            return "Всё путем - сервис запущен.";
        } else {
            throw new RuntimeException("Сервис нихуя не фурычит!");
        }
    }
}