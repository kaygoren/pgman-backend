package yte.pgman.service;

import yte.pgman.repository.pojo.ConfigurationPghba;
import yte.pgman.repository.pojo.ConfigurationPostgres;
import java.sql.SQLException;
import java.util.List;


public interface ConfigurationService {

    void savePostgresConf(String tableName, String op, List<ConfigurationPostgres> configurationPostgresList) throws SQLException;
    void savePghbaConf(String tableName, String op, List<ConfigurationPghba> configurationPghbaList) throws SQLException;
    ConfigurationPostgres getPostgresConfigurationWithID(int id) throws SQLException;
}
