package by.imix.homebot;

import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;

/**
 * Команда получение файла с заданиями на сложение и вычитание
 */
public class SendImager extends OperationCommand {
    private TelegramLongPollingCommandBot telegramLongPollingCommandBot;
    public SendImager(String identifier, String description, TelegramLongPollingCommandBot telegramLongPollingCommandBot) {
        super(identifier, description);
        this.telegramLongPollingCommandBot = telegramLongPollingCommandBot;
    }

    public SendImager(String identifier, String description) {
        super(identifier, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        //формируем имя пользователя - поскольку userName может быть не заполнено, для этого случая используем имя и фамилию пользователя
        String userName = (user.getUserName() != null) ? user.getUserName() :
                String.format("%s %s", user.getLastName(), user.getFirstName());
        //обращаемся к методу суперкласса для формирования файла на сложение и вычитание (за это отвечает метод getPlusMinus() перечисления OperationEnum) и отправки его пользователю
        sendAnswer(absSender, chat.getId(), this.getDescription(), this.getCommandIdentifier(), userName);
//        sendAnswer(absSender, chat.getId(), this.getCommandIdentifier(), userName,
//                "Давайте начнём! Если Вам нужна помощь, нажмите /help");
        SenderImageTimer senderImageTimer = new SenderImageTimer(telegramLongPollingCommandBot, chat.getId().toString());
        Thread t1 =new Thread(senderImageTimer);
        t1.start();
    }
}
