package yte.pgman.controller;


import yte.pgman.controller.dto.ConfigurationPghbaDTO;
import yte.pgman.controller.dto.ConfigurationPostgresqlDTO;

import java.sql.SQLException;
import java.util.List;

public interface ConfigurationController {

    void saveConfigurationPostgresql(List<ConfigurationPostgresqlDTO> configurationPostgresqlDTOList) throws SQLException;
    void saveConfigurationPghba(List<ConfigurationPghbaDTO> configurationPghbaDTOList) throws SQLException;
    ConfigurationPostgresqlDTO getConfigurationWithID(int id) throws SQLException;
}
