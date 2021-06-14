package by.imix.homebot;

import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;

public class SenderImageTimer implements Runnable{
    private TelegramLongPollingCommandBot telegramLongPollingCommandBot;
    private String id;
    public SenderImageTimer(TelegramLongPollingCommandBot telegramLongPollingCommandBot, String id) {
        this.telegramLongPollingCommandBot = telegramLongPollingCommandBot;
        this.id=id;
    }

    @Override
    public void run() {
        SendPhoto sendPhoto = SendPhoto.builder().photo(new InputFile(new File("D:\\файлы с работы\\3_zip\\3\\Grow1_files\\de7bb89506ea947af9145c3234922aa1.jpg")))
                .chatId(id).build();
        int i = 0;
        while (i < 5) {
            try {
                telegramLongPollingCommandBot.execute(sendPhoto);


            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
            i += 1;
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
