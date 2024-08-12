package data.centre;

import java.util.Scanner;

public class Main {

    public static DataCenter dataCenter = new DataCenter();
    public static DataCenterService dataCenterService = new DataCenterService(dataCenter);
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        initDataCenter();

        ResourceRequest request = new ResourceRequest(500);
        ResourceRequest request1 = new ResourceRequest(1000);
        ResourceRequest request2 = new ResourceRequest(1500);
        ResourceRequest request3 = new ResourceRequest(300);

        dataCenterService.allocateResources(request);
        System.out.println("Общая нагрузка серверов " + dataCenter.getTotalServerLoad());
        System.out.println("Потребление после первого выделения мощностей " +
                dataCenter.getTotalServerEnergyConsumption());
        System.out.println("---");

        dataCenterService.allocateResources(request1);
        System.out.println("Общая нагрузка серверов " + dataCenter.getTotalServerLoad());
        System.out.println("Потребление после второго выделения " +
                "мощностей и добавления нового сервера " + dataCenter.getTotalServerEnergyConsumption());
        System.out.println("---");

        dataCenterService.releaseResources(request2);
        System.out.println("Общая нагрузка серверов после высвобождения ресурсов "
                + dataCenter.getTotalServerLoad());
        System.out.println("Потребление энергии после высвобождения ресурсов " +
                dataCenter.getTotalServerEnergyConsumption());
        System.out.println("---");

        dataCenter.printServers();
        System.out.println("---");

        dataCenterService.allocateResources(request3);
        System.out.println("Общая нагрузка серверов " + dataCenter.getTotalServerLoad());
        System.out.println("Потребление после третьего выделения мощностей " +
                dataCenter.getTotalServerEnergyConsumption());
        System.out.println("---");

        selectingServerDeleteMethod();

        dataCenterService.optimize(dataCenter);
        System.out.println("---");

        dataCenter.printServers();
    }

    public static void initDataCenter() {
        dataCenter.setDataCenterService(dataCenterService);
        Server server1 = new Server(150, 1.5, 300);
        Server server2 = new Server(100, 1, 300);
        Server server3 = new Server(50, 0.5, 300);

        dataCenter.addServer(server1);
        dataCenter.addServer(server2);
        dataCenter.addServer(server3);
        System.out.println("Общая нагрузка серверов " + dataCenter.getTotalServerLoad());
        System.out.println("Потребление в начале " + dataCenter.getTotalServerEnergyConsumption());
        System.out.println("---");
    }

    public static void selectingServerDeleteMethod() {
        System.out.println("Введите команду: 'delete' или 'hard delete': ");
        String command = scanner.nextLine();

        if (command.equalsIgnoreCase("delete")) {
            System.out.println("Введите ID сервера для удаления:");
            if (scanner.hasNextInt()) {
                int serverId = scanner.nextInt();
                scanner.nextLine();
                dataCenter.deleteServer(serverId);
            } else {
                System.out.println("Неверный ввод. Ожидалось число.");
                scanner.nextLine();
            }
        } else if (command.equalsIgnoreCase("hard delete")) {
            System.out.println("Введите ID сервера для удаления:");
            if (scanner.hasNextInt()) {
                int serverId = scanner.nextInt();
                scanner.nextLine();
                dataCenter.hardDeleteServer(serverId);
            } else {
                System.out.println("Неверный ввод. Ожидалось число.");
                scanner.nextLine();
            }
        } else {
            System.out.println("Неизвестная команда. Попробуйте снова.");
        }
        System.out.println("---");
    }
}
