package yte.pgman.controller.dto;

import yte.pgman.repository.pojo.ConfigurationPostgresql;


public class ConfigurationPostgresqlDTO {

    private int id;
    private String key;
    private String value;

    public ConfigurationPostgresqlDTO() {

    }

    public ConfigurationPostgresqlDTO(ConfigurationPostgresql configurationPostgresql) {
        this.id = configurationPostgresql.getId();
        this.key = configurationPostgresql.getKey();
        this.value = configurationPostgresql.getValue();
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
