package Microsoft;

public class MailSender {
    public static void main(String[] args) {

        int numberOfMessages = 1001;

        int poolCounter = 0;
        int startIndex = 0;
        int endIndex;

        for (int i = 0; i <= numberOfMessages; i++) {
            //Если пул сообщений == 0
            if (poolCounter == 0) {
                //Записываем startIndex
                startIndex = i;
            }


            //Если counter == 200
            if (poolCounter == 200) {
                //Записываем endIndex
                endIndex = i;
                //Запускаем отправку группы писем
                SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
                senderRunnable.run();

                //Сбрасываем counter
                poolCounter = 0;
            }

            //Инкрементируем счетчик
            poolCounter++;

            //Если дошли до конца списка но counter != 200
            if (i == numberOfMessages) {
                //Отправляем оставшиеся
                endIndex = i;

                SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
                senderRunnable.run();

            }

        }
    }
}

