package yte.pgman.controller.dto;

import yte.pgman.repository.pojo.Configuration;

public class ConfigurationDTO {

    private String ConfigurationKey;
    private String ConfigurationValue;
    private int ConfigurationID;

    public ConfigurationDTO(Configuration configuration) {
        this.ConfigurationKey = configuration.getKey();
        this.ConfigurationValue = configuration.getValue();
        this.ConfigurationID = configuration.getId();
    }

    public String getConfigurationKey() {
        return ConfigurationKey;
    }

    public void setConfigurationKey(String configurationKey) {
        ConfigurationKey = configurationKey;
    }

    public String getConfigurationValue() {
        return ConfigurationValue;
    }

    public void setConfigurationValue(String configurationValue) {
        ConfigurationValue = configurationValue;
    }

    public int getConfigurationID() {
        return ConfigurationID;
    }

    public void setConfigurationID(int configurationID) {
        ConfigurationID = configurationID;
    }
}
