package yte.pgman.service;

import yte.pgman.repository.pojo.ConfigurationPghba;
import yte.pgman.repository.pojo.ConfigurationPostgres;
import java.sql.SQLException;
import java.util.List;


public interface ConfigurationService {

    void savePostgresConf(String operation, String tableName, List<ConfigurationPostgres> configurationPostgresList) throws SQLException;
    void savePghbaConf(String operation, String tableName, List<ConfigurationPghba> configurationPghbaList) throws SQLException;
    ConfigurationPostgres getPostgresConfigurationWithID(int id) throws SQLException;
}
