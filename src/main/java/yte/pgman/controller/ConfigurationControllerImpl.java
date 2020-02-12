package yte.pgman.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yte.pgman.controller.dto.ConfigurationPghbaDTO;
import yte.pgman.controller.dto.ConfigurationPostgresDTO;
import yte.pgman.repository.pojo.ConfigurationPghbaList;
import yte.pgman.repository.pojo.ConfigurationPostgres;
import yte.pgman.repository.pojo.ConfigurationPostgresList;
import yte.pgman.service.ConfigurationService;

import java.sql.SQLException;
import java.util.List;


@RestController
@RequestMapping("/configuration")
public class ConfigurationControllerImpl implements ConfigurationController {

    @Autowired
    private ConfigurationService configurationService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/add/postgresql/{tableName}")
    @Override
    public void addPostgresConf(@PathVariable String tableName, @RequestBody List<ConfigurationPostgresDTO> configurationPostgresDTOList) throws SQLException {
        ConfigurationPostgresList configurationPostgresList = new ConfigurationPostgresList(configurationPostgresDTOList);
        configurationService.savePostgresConf(tableName, "add", configurationPostgresList.getConfigurationPostgresList());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/replace/postgresql/{tableName}")
    @Override
    public void replacePostgresConf(@PathVariable String tableName, @RequestBody List<ConfigurationPostgresDTO> configurationPostgresDTOList) throws SQLException {
        ConfigurationPostgresList configurationPostgresList = new ConfigurationPostgresList(configurationPostgresDTOList);
        configurationService.savePostgresConf(tableName, "replace", configurationPostgresList.getConfigurationPostgresList());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/add/hba/{tableName}")
    @Override
    public void addPghbaConf(@PathVariable String tableName, @RequestBody List<ConfigurationPghbaDTO> configurationPghbaDTOList) throws SQLException {
        ConfigurationPghbaList configurationPghbaList = new ConfigurationPghbaList(configurationPghbaDTOList);
        configurationService.savePghbaConf(tableName, "add",configurationPghbaList.getConfigurationPghbaList());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/replace/hba/{tableName}")
    @Override
    public void replacePghbaConf(@PathVariable String tableName, @RequestBody List<ConfigurationPghbaDTO> configurationPghbaDTOList) throws SQLException {
        ConfigurationPghbaList configurationPghbaList = new ConfigurationPghbaList(configurationPghbaDTOList);
        configurationService.savePghbaConf(tableName, "replace", configurationPghbaList.getConfigurationPghbaList());
    }

    @GetMapping("/get")
    @Override
    public ConfigurationPostgresDTO getPostgresConfigurationWithID(@RequestParam int id) throws SQLException {

        ConfigurationPostgres configurationPostgres = configurationService.getPostgresConfigurationWithID(id);
        return new ConfigurationPostgresDTO(configurationPostgres);
    }
}
