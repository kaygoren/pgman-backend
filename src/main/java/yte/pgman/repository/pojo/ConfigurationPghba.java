package yte.pgman.repository.pojo;

public class ConfigurationPghba {

    private int id;
    private String type;
    private String database;
    private String user;
    private String address;
    private String method;

    public ConfigurationPghba() {}

    public ConfigurationPghba(int id, String type, String database, String user, String address, String method) {
        this.id = id;
        this.type = type;
        this.database = database;
        this.user = user;
        this.address = address;
        this.method = method;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
