package the.atomicity.tagcrawler.model;

public enum MediaType {

    PICTURE("my_pictures"), VIDEO("my_videos");

    private final String table;

    MediaType(String table) {
        this.table = table;
    }

    public String getTable() {
        return table;
    }
}
