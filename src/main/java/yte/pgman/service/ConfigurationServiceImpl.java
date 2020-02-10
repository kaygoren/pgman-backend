package yte.pgman.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yte.pgman.repository.ConfigurationRepository;
import yte.pgman.repository.pojo.Configuration;

import java.sql.SQLException;

@Service
public class ConfigurationServiceImpl implements ConfigurationService {

    @Autowired
    private ConfigurationRepository configurationRepository;


    @Override
    public void saveConfiguration(Configuration configuration) throws SQLException {
        configurationRepository.saveConfiguration(configuration);
    }

    @Override
    public Configuration getConfigurationWithID(int id) throws SQLException {
        return configurationRepository.getConfigurationWithID(id);
    }
}
