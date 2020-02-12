package yte.pgman.controller;


import yte.pgman.controller.dto.ConfigurationPghbaDTO;
import yte.pgman.controller.dto.ConfigurationPostgresDTO;

import java.sql.SQLException;
import java.util.List;

public interface ConfigurationController {

    void addPostgresConf(String tableName, List<ConfigurationPostgresDTO> configurationPostgresDTOList) throws SQLException;
    void replacePostgresConf(String tableName, List<ConfigurationPostgresDTO> configurationPostgresDTOList) throws SQLException;
    void addPghbaConf(String tableName, List<ConfigurationPghbaDTO> configurationPghbaDTOList) throws SQLException;
    void replacePghbaConf(String tableName, List<ConfigurationPghbaDTO> configurationPghbaDTOList) throws SQLException;
    ConfigurationPostgresDTO getPostgresConfigurationWithID(int id) throws SQLException;
}
