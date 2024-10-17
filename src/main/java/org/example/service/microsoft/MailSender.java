package org.example.service.microsoft;

import org.example.model.microsoft.SenderRunnable;

import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        List<Thread> threads = SenderRunnable.optimizeSendingNotifications(1000, 5);
        SenderRunnable.startThreadList(threads);
    }
}
