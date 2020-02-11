package yte.pgman.controller.dto;

import yte.pgman.repository.pojo.ConfigurationPostgres;


public class ConfigurationPostgresDTO {

    private int id;
    private String key;
    private String value;

    public ConfigurationPostgresDTO() {

    }

    public ConfigurationPostgresDTO(ConfigurationPostgres configurationPostgres) {
        this.id = configurationPostgres.getId();
        this.key = configurationPostgres.getKey();
        this.value = configurationPostgres.getValue();
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
