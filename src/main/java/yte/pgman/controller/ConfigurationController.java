package yte.pgman.controller;


import yte.pgman.controller.dto.ConfigurationPghbaDTO;
import yte.pgman.controller.dto.ConfigurationPostgresDTO;

import java.sql.SQLException;
import java.util.List;

public interface ConfigurationController {

    void savePostgresConf(String tableName, List<ConfigurationPostgresDTO> configurationPostgresDTOList) throws SQLException;
    void savePghbaConf(String tableName, List<ConfigurationPghbaDTO> configurationPghbaDTOList) throws SQLException;
    ConfigurationPostgresDTO getPostgresqlConfigurationWithID(int id) throws SQLException;
}
