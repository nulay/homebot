package by.imix.homebot.web.uploadingfiles;

import by.imix.homebot.HomeBotWatcher;
import by.imix.homebot.web.uploadingfiles.storage.StorageProperties;
import by.imix.homebot.web.uploadingfiles.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class UploadingFilesApplication {

    public static void main(String[] args) {
        SpringApplication.run(UploadingFilesApplication.class, args);
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            HomeBotWatcher bot = new HomeBotWatcher("HomeBotWatcherbot", "5324476725:AAE0ISpSU3i0kkiqiXGczgnCNiNZ6QqGp44");
            botsApi.registerBot(bot);
//            botsApi.registerBot(new HomeBotWatcher(getenv.get("BOT_NAME"), getenv.get("BOT_TOKEN")));


        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }
}