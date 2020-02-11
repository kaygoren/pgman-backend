package yte.pgman.service;

import yte.pgman.repository.pojo.ConfigurationPghba;
import yte.pgman.repository.pojo.ConfigurationPostgres;
import java.sql.SQLException;
import java.util.List;


public interface ConfigurationService {

    void save(String tableName, List<ConfigurationPostgres> configurationPostgresList) throws SQLException;
    void savePghbaConf(String tableName, List<ConfigurationPghba> configurationPghbaList) throws SQLException;
    ConfigurationPostgres getPostgresqlConfigurationWithID(int id) throws SQLException;
}
