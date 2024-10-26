package school.faang.sendraven;

public class Main {
    public static void main(String[] args) {
        MessagingSystem messagingSystem = new MessagingSystem();
        Kingdom kingdomLights = new Kingdom("Kingdom of Lights");
        Kingdom kingdomTornadoes = new Kingdom("Kingdom of Tornadoes");
        Kingdom kingdomArsei = new Kingdom("Kingdom of Arsei");

        messagingSystem.sendRaven(kingdomLights, kingdomTornadoes);
        messagingSystem.sendRaven(kingdomTornadoes, kingdomArsei);
        messagingSystem.sendRaven(kingdomLights, kingdomArsei);
        messagingSystem.sendRaven(kingdomArsei, kingdomTornadoes);
        messagingSystem.sendRaven(kingdomArsei, kingdomLights);

        messagingSystem.shutdown();
    }
}
