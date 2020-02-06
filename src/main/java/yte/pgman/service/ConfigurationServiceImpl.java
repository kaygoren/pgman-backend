package yte.pgman.service;


import org.springframework.beans.factory.annotation.Autowired;
import yte.pgman.repository.ConfigurationRepository;
import yte.pgman.repository.pojo.Configuration;

public class ConfigurationServiceImpl implements ConfigurationService {

    private ConfigurationRepository configurationRepository;

    @Autowired
    public ConfigurationServiceImpl(ConfigurationRepository configurationRepository) {
        this.configurationRepository = configurationRepository;
    }

    @Override
    public void saveConfiguration(Configuration configuration) {
        configurationRepository.saveConfiguration(configuration);
    }

    @Override
    public Configuration getConfigurationWithID(int id) {
        return null;
    }
}
