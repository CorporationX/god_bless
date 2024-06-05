package faang.school.godbless.data;

public class Main {

    public static void main(String[] args) {

        // создаем dataCenter в котором будум храниться все сервера
        DataCenter dataCenter = new DataCenter();

        // создаем сервис для работы с серверами
        DataCenterService dataCenterService = new DataCenterService();

        // выделяем сервер
        dataCenterService.createServer(1, 1, 1);


    }
}
