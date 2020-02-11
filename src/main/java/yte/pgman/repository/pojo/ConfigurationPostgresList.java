package yte.pgman.repository.pojo;

import yte.pgman.controller.dto.ConfigurationPostgresDTO;

import java.util.ArrayList;
import java.util.List;

public class ConfigurationPostgresList {
    private List<ConfigurationPostgres> configurationPostgresList = new ArrayList<>();

    public ConfigurationPostgresList(List<ConfigurationPostgresDTO> configurationPostgresDTOList) {
        for(ConfigurationPostgresDTO configurationPostgresDTO : configurationPostgresDTOList) {
            ConfigurationPostgres configurationPostgres = new ConfigurationPostgres();
            configurationPostgres.setId(configurationPostgresDTO.getId());
            configurationPostgres.setKey(configurationPostgresDTO.getKey());
            configurationPostgres.setValue(configurationPostgresDTO.getValue());
            configurationPostgresList.add(configurationPostgres);
        }
    }

    public List<ConfigurationPostgres> getConfigurationPostgresList() {
        return configurationPostgresList;
    }

    public void setConfigurationPostgresList(List<ConfigurationPostgres> configurationPostgresList) {
        this.configurationPostgresList = configurationPostgresList;
    }
}
