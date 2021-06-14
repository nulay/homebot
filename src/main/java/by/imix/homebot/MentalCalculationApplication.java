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
            HomeBotWatcher bot = new HomeBotWatcher("HomeWatcherImixBot", "1675766904:AAHKONqBrNczk5M10g8M-T4aeww5ic85rIY");
            botsApi.registerBot(bot);
//            botsApi.registerBot(new HomeBotWatcher(getenv.get("BOT_NAME"), getenv.get("BOT_TOKEN")));


        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}