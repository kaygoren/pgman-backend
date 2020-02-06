package yte.pgman.controller;


import yte.pgman.controller.dto.ConfigurationDTO;
import yte.pgman.repository.pojo.Configuration;

import java.util.List;

public interface ConfigurationController {

    void saveConfiguration(List<ConfigurationDTO> configurationDTOList);
    ConfigurationDTO getConfigurationWithID(int id);
}
