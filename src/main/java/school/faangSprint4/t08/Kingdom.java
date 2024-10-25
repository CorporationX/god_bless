package school.faangSprint4.t08;

public record Kingdom(String name) {

    public String sendMessage(Kingdom receiver) throws Exception {
        if (Math.random() < 0.5) {
            throw new Exception("Ворон не смог доставить сообщение из " + name + " в " + receiver.name());
        }
        return "Сообщение успешно доставлено из " + name + " в " + receiver.name();
    }
}