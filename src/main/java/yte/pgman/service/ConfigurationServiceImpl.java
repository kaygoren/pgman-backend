package yte.pgman.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yte.pgman.repository.ConfigurationRepository;
import yte.pgman.repository.pojo.ConfigurationPghba;
import yte.pgman.repository.pojo.ConfigurationPostgresql;

import java.sql.SQLException;

@Service
public class ConfigurationServiceImpl implements ConfigurationService {

    @Autowired
    private ConfigurationRepository configurationRepository;


    @Override
    public void saveConfigurationPostgresql(ConfigurationPostgresql configurationPostgresql) throws SQLException {
        configurationRepository.saveConfigurationPostgresql(configurationPostgresql);
    }

    @Override
    public void saveConfigurationPghba(ConfigurationPghba configurationPghba) throws SQLException {
        configurationRepository.saveConfigurationPghba(configurationPghba);
    }

    @Override
    public ConfigurationPostgresql getConfigurationWithID(int id) throws SQLException {
        return configurationRepository.getConfigurationWithID(id);
    }
}
