package by.imix.homebot;

import static by.imix.homebot.Settings.getDefaultSettings;

/**
 * Обработка сообщения, не являющегося командой (т.е. обычного текста не начинающегося с "/")
 */
public class NonCommand {

    public String nonCommandExecute(Long chatId, String userName, String text) {
        Settings settings;
        String answer;
        try {
            //создаём настройки из сообщения пользователя
            settings = createSettings(text);
            //добавляем настройки в мапу, чтобы потом их использовать для этого пользователя при генерации файла
            saveUserSettings(chatId, settings);
            answer = "Настройки обновлены. Вы всегда можете их посмотреть с помощью /settings";
            //логируем событие, используя userName
        } catch (IllegalSettingsException e) {
            answer = e.getMessage() +
                    "\n\n Настройки не были изменены. Вы всегда можете их посмотреть с помощью /settings";
            //логируем событие, используя userName
        } catch (Exception e) {
            answer = "Простите, я не понимаю Вас. Возможно, Вам поможет /help";
            //логируем событие, используя userName
        }
        return answer;
    }

    /**
     * Создание настроек из полученного пользователем сообщения
     * @param text текст сообщения
     * @throws IllegalArgumentException пробрасывается, если сообщение пользователя не соответствует формату
     */
    private Settings createSettings(String text) throws IllegalArgumentException {
        //отсекаем файлы, стикеры, гифки и прочий мусор
        if (text == null) {
            throw new IllegalArgumentException("Сообщение не является текстом");
        }
        //создаём из сообщения пользователя 3 числа-настройки (min, max, listCount) либо пробрасываем исключение о несоответствии сообщения требуемому формату
        return getDefaultSettings();
    }

    /**
     * Добавление настроек пользователя в мапу, чтобы потом их использовать для этого пользователя при генерации файла
     * Если настройки совпадают с дефолтными, они не сохраняются, чтобы впустую не раздувать мапу
     * @param chatId id чата
     * @param settings настройки
     */
    private void saveUserSettings(Long chatId, Settings settings) {
        if (!settings.equals(getDefaultSettings())) {
            HomeBotWatcher.getUserSettings().put(chatId, settings);
        } else {
            HomeBotWatcher.getUserSettings().remove(chatId);
        }
    }
}