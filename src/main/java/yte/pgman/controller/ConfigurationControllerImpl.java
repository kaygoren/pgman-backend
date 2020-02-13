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

    @CrossOrigin()
    @PostMapping("/{operation}/postgresql/{tableName}")
    @Override
    public void savePostgresConf(@PathVariable String operation, @PathVariable String tableName, @RequestBody List<ConfigurationPostgresDTO> configurationPostgresDTOList) throws SQLException {
        ConfigurationPostgresList configurationPostgresList = new ConfigurationPostgresList(configurationPostgresDTOList);
        configurationService.savePostgresConf(operation, tableName, configurationPostgresList.getConfigurationPostgresList());
    }

//    @CrossOrigin(origins = "http://10.222.60.87:3000")
    @CrossOrigin()
    @PostMapping("/{operation}/hba/{tableName}")
    @Override
    public void savePghbaConf(@PathVariable String operation, @PathVariable String tableName, @RequestBody List<ConfigurationPghbaDTO> configurationPghbaDTOList) throws SQLException {
        ConfigurationPghbaList configurationPghbaList = new ConfigurationPghbaList(configurationPghbaDTOList);
        configurationService.savePghbaConf(operation, tableName, configurationPghbaList.getConfigurationPghbaList());
    }

    @GetMapping("/get")
    @Override
    public ConfigurationPostgresDTO getPostgresConfigurationWithID(@RequestParam int id) throws SQLException {

        ConfigurationPostgres configurationPostgres = configurationService.getPostgresConfigurationWithID(id);
        return new ConfigurationPostgresDTO(configurationPostgres);
    }
}
