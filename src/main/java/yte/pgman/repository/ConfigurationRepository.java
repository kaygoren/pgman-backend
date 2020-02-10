package yte.pgman.repository;

import yte.pgman.repository.pojo.Configuration;

import java.sql.SQLException;


public interface ConfigurationRepository {

    void saveConfiguration(Configuration configuration) throws SQLException;

    Configuration getConfigurationWithID(int id) throws SQLException;
}
