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
    public void savePostgresConf(String tableName, String op, List<ConfigurationPostgres> configurationPostgresList) throws SQLException {
        configurationRepository.savePostgresConf(tableName, op, configurationPostgresList);
    }

    @Override
    public void savePghbaConf(String tableName, String op, List<ConfigurationPghba> configurationPghbaList) throws SQLException {
        configurationRepository.savePghbaConf(tableName, op, configurationPghbaList);
    }

    @Override
    public ConfigurationPostgres getPostgresConfigurationWithID(int id) throws SQLException {
        return configurationRepository.getPostgresConfigurationWithID(id);
    }
}
