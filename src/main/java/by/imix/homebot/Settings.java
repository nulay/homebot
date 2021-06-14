package by.imix.homebot;

public class Settings {
    private int min, max, listCount;

    public Settings(int min, int max, int listCount) {
        this.min = min;
        this.max = max;
        this.listCount = listCount;
    }

    public static Settings getDefaultSettings() {
        return new Settings(1,10,5);
    }
}
