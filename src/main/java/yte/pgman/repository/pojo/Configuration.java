package yte.pgman.repository.pojo;

public class Configuration {

    private String key;
    private String value;
    private int id;

    public Configuration() {

    }

    public Configuration(String key, String value, int id) {
        this.key = key;
        this.value = value;
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
