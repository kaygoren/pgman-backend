package yte.pgman.repository.pojo;

import yte.pgman.controller.dto.ConfigurationPghbaDTO;

import java.util.ArrayList;
import java.util.List;

public class ConfigurationPghbaList {
    private List<ConfigurationPghba> configurationPghbaList = new ArrayList<>();

    public ConfigurationPghbaList(List<ConfigurationPghbaDTO> configurationPghbaDTOList) {
        for(ConfigurationPghbaDTO configurationPghbaDTO : configurationPghbaDTOList) {
            ConfigurationPghba configurationPghba = new ConfigurationPghba();
            configurationPghba.setType(configurationPghbaDTO.getType());
            configurationPghba.setDatabase(configurationPghbaDTO.getDatabase());
            configurationPghba.setUser(configurationPghbaDTO.getUser());
            configurationPghba.setAddress(configurationPghbaDTO.getAddress());
            configurationPghba.setMethod(configurationPghbaDTO.getMethod());
            configurationPghbaList.add(configurationPghba);
        }
    }

    public List<ConfigurationPghba> getConfigurationPghbaList() {
        return configurationPghbaList;
    }

    public void setConfigurationPghbaList(List<ConfigurationPghba> configurationPghbaList) {
        this.configurationPghbaList = configurationPghbaList;
    }
}
