package derschrank.sprint04.task08.bjstwo_50617;

import java.util.concurrent.CompletableFuture;

public record Kingdom(
        String name
) {
    public void sendMessage(Kingdom receiver, String msg) {
        Raven raven = new Raven(msg, this, receiver);
        CompletableFuture<Raven> future = CompletableFuture.supplyAsync(raven::send);
        System.out.printf("%n -> Kingdom *%s* sended to kingdom *%s* message: %s%n", name, receiver.name(), msg);

        future.handle((ravenWithAnswer, exception) -> {
            if (exception == null) {
                if (ravenWithAnswer.type() == TypeMsg.SUCCESS) {
                    System.out.printf(" ++ Kingdom *%s*. SUCCESS. "
                             + "Message was received by *%s* SUCCESS!!!%n", name, receiver.name());
                } else {
                    System.out.printf(" -- Kingdom *%s*. NOT SUCCESS. "
                             + "Message was received by *%s*, but WITH OUT SUCCESS!!!%n", name, receiver.name());
                }
            } else {
                System.out.printf(" !! Kingdom *%s* doesn't know if the message "
                         + "was received by *%s*%n", name, receiver.name());
            }
            return raven;
        });
    }


    public void receiveMessage(Kingdom sender, String msg) {
        System.out.printf(" >= Kingdom *%s* received from kingdom *%s* message: %s%n", name, sender.name(), msg);
    }

    public Raven receiveRaven(Raven incomeRaven) {
        receiveMessage(incomeRaven.sender(), incomeRaven.msg());
        return new Raven(TypeMsg.SUCCESS, incomeRaven);
    }
}
