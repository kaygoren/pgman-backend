package yte.pgman.repository;

import yte.pgman.repository.pojo.ConfigurationPghba;
import yte.pgman.repository.pojo.ConfigurationPostgresql;

import java.sql.SQLException;


public interface ConfigurationRepository {

    void saveConfigurationPostgresql(ConfigurationPostgresql configurationPostgresql) throws SQLException;
    void saveConfigurationPghba(ConfigurationPghba configurationPghba) throws SQLException;
    ConfigurationPostgresql getConfigurationWithID(int id) throws SQLException;
}
