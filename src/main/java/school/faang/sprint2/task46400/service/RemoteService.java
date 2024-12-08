package school.faang.sprint2.task46400.service;

public class RemoteService {

    public static String wifiCall(String param) throws RuntimeException {
        // Здесь возникнет ошибка для демонстрации
        throw new RuntimeException("Service wifiCall(" + param + ") unavailable");
    }

    public static String networkCall(String param) throws RuntimeException {
        return "Service networkCall(" + param + ") successfully called.";
    }


}
