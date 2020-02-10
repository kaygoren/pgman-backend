package yte.pgman.controller.dto;

import yte.pgman.repository.pojo.Configuration;

import java.io.Serializable;

public class ConfigurationDTO {

    private int configurationID;
    private String configurationKey;
    private String configurationValue;

    public ConfigurationDTO() {

    }

    public ConfigurationDTO(Configuration configuration) {
        this.configurationID = configuration.getId();
        this.configurationKey = configuration.getKey();
        this.configurationValue = configuration.getValue();
    }

    public String getConfigurationKey() {
        return configurationKey;
    }

    public void setConfigurationKey(String configurationKey) {
        this.configurationKey = configurationKey;
    }

    public String getConfigurationValue() {
        return configurationValue;
    }

    public void setConfigurationValue(String configurationValue) {
        this.configurationValue = configurationValue;
    }

    public int getConfigurationID() {
        return configurationID;
    }

    public void setConfigurationID(int configurationID) {
        this.configurationID = configurationID;
    }
}
