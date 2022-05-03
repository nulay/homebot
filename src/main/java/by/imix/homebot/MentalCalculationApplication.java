package by.imix.homebot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.File;
import java.util.Map;

public class MentalCalculationApplication {
    private static final Map<String, String> getenv = System.getenv();

    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            HomeBotWatcher bot = new HomeBotWatcher("HomeWatcherbot", "5324476725:AAE0ISpSU3i0kkiqiXGczgnCNiNZ6QqGp44");
            botsApi.registerBot(bot);
//            botsApi.registerBot(new HomeBotWatcher(getenv.get("BOT_NAME"), getenv.get("BOT_TOKEN")));


        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}