package by.imix.homebot;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/**
 * Суперкласс для команд создания заданий с различными операциями
 */
abstract class OperationCommand extends BotCommand {
//    private PlusMinusService service;

    OperationCommand(String identifier, String description) {
        super(identifier, description);
//        this.service = new PlusMinusService(new WordFileProcessorImpl(), new Calculator());
    }

    /**
     * Отправка ответа пользователю
     */
    void sendAnswer(AbsSender absSender, Long chatId, String description, String commandName, String userName) {
        try {
            absSender.execute(createDocument(chatId, description));
        } catch (IOException | IllegalArgumentException e) {
            sendError(absSender, chatId, commandName, userName);
            e.printStackTrace();
        } catch (TelegramApiException e) {
            //логируем сбой Telegram Bot API, используя commandName и userName
        }
    }

    /**
     * Создание документа для отправки пользователю
     * @param chatId id чата
     * @param operations список типов операций (сложение и/или вычитание)
     * @param fileName имя, которое нужно присвоить файлу
     */
    private SendDocument createDocument(Long chatId, String fileName) throws IOException {
        FileInputStream stream = new FileInputStream(new File(Path.of("").toAbsolutePath()+File.separator+"1651481134161" +
                ".jpg"));
        SendDocument document = new SendDocument();
        document.setChatId(chatId.toString());
        document.setDocument(new InputFile(stream, String.format("%s.jpg", fileName)));
        return document;
    }

    /**
     * Отправка пользователю сообщения об ошибке
     */
    private void sendError(AbsSender absSender, Long chatId, String commandName, String userName) {
        try {
            absSender.execute(new SendMessage(chatId.toString(), "Похоже, я сломался. Попробуйте позже"));
        } catch (TelegramApiException e) {
            //логируем сбой Telegram Bot API, используя commandName и userName
        }
    }
}