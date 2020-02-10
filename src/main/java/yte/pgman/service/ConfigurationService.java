package yte.pgman.service;

import yte.pgman.repository.pojo.Configuration;
import java.sql.SQLException;


public interface ConfigurationService {

    void saveConfiguration(Configuration configuration) throws SQLException;
    Configuration getConfigurationWithID(int id) throws SQLException;
}
