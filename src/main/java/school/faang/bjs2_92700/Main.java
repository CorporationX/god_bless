package school.faang.bjs2_92700;

public class Main {
    public static void main(String[] args) {
        KingdomMessenger.sendRaven(new Kingdom("Болгарская империя"), new Kingdom("Киевская Русь"));
        KingdomMessenger.sendRaven(new Kingdom("Византийская империя"), new Kingdom("Хазарский Каганат"));
        KingdomMessenger.sendRaven(new Kingdom("Хазарский Каганат"), new Kingdom("Киевская Русь"));
        KingdomMessenger.sendRaven(new Kingdom("Хазарский Каганат"), new Kingdom("Византийская империя"));
        KingdomMessenger.EXECUTOR.shutdown();



    }
}
