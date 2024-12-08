package school.faang.sprint2.task46400.service;

public class RemoteService {

    public static String wifi_call(String param) throws RuntimeException {
        // Здесь возникнет ошибка для демонстрации
        throw new RuntimeException("Service wifi_call(" + param + ") unavailable");
    }

    public static String network_call(String param) throws RuntimeException {
        return "Service network_call(" + param + ") successfully called.";
    }


}
