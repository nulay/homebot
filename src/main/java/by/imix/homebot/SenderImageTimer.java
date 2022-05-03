package by.imix.homebot;

import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.nio.file.Path;

public class SenderImageTimer implements Runnable{
    private TelegramLongPollingCommandBot telegramLongPollingCommandBot;
    private String id;
    public SenderImageTimer(TelegramLongPollingCommandBot telegramLongPollingCommandBot, String id) {
        this.telegramLongPollingCommandBot = telegramLongPollingCommandBot;
        this.id=id;
    }

    @Override
    public void run() {
        SendPhoto sendPhoto = SendPhoto.builder().photo(new InputFile(new File(Path.of("").toAbsolutePath()+File.separator+"1651481134161" +
                ".jpg")))
                .chatId(id).build();
        int i = 0;
        while (i < 1) {
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
