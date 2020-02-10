package yte.pgman.controller;


import yte.pgman.controller.dto.ConfigurationDTO;
import yte.pgman.repository.pojo.Configuration;

import java.sql.SQLException;
import java.util.List;

public interface ConfigurationController {

    void saveConfiguration(List<ConfigurationDTO> configurationDTOList) throws SQLException;
    ConfigurationDTO getConfigurationWithID(int id) throws SQLException;
}
