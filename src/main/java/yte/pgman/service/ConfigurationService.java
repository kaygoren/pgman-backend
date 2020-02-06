package yte.pgman.service;


import org.springframework.stereotype.Service;
import yte.pgman.repository.pojo.Configuration;

@Service
public interface ConfigurationService {

    void saveConfiguration(Configuration configuration);
    Configuration getConfigurationWithID(int id);
}
