package school.faang.multithreading.assynchron;

public class Main {
    public static void main(String[] args) {
        MasterCardService service = new MasterCardService();
        service.doAll();
    }
}

