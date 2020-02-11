package yte.pgman.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yte.pgman.repository.ConfigurationRepository;
import yte.pgman.repository.pojo.ConfigurationPghba;
import yte.pgman.repository.pojo.ConfigurationPostgres;

import java.sql.SQLException;
import java.util.List;

@Service
public class ConfigurationServiceImpl implements ConfigurationService {

    @Autowired
    private ConfigurationRepository configurationRepository;

    @Override
    public void save(String tableName, List<ConfigurationPostgres> configurationPostgresList) throws SQLException {
        configurationRepository.save(tableName, configurationPostgresList);
    }

    @Override
    public void savePghbaConf(String tableName, List<ConfigurationPghba> configurationPghbaList) throws SQLException {
        configurationRepository.savePghbaConf(tableName, configurationPghbaList);
    }

    @Override
    public ConfigurationPostgres getPostgresqlConfigurationWithID(int id) throws SQLException {
        return configurationRepository.getPostgresqlConfigurationWithID(id);
    }
}
