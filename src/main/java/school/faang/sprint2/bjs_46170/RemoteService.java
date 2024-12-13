package school.faang.sprint2.bjs_46170;

public class RemoteService {
    public static String call(String param) throws Exception {
        System.out.println(param);
        throw new Exception("Сервис недоступен");
    }
}
