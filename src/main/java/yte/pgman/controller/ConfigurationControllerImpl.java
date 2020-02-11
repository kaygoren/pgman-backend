package yte.pgman.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yte.pgman.controller.dto.ConfigurationPghbaDTO;
import yte.pgman.controller.dto.ConfigurationPostgresqlDTO;
import yte.pgman.repository.pojo.ConfigurationPghba;
import yte.pgman.repository.pojo.ConfigurationPostgresql;
import yte.pgman.service.ConfigurationService;

import java.sql.SQLException;
import java.util.List;


@RestController
@RequestMapping("/configuration")
public class ConfigurationControllerImpl implements ConfigurationController {

    @Autowired
    private ConfigurationService configurationService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/savepostgresql")
    @Override
    public void saveConfigurationPostgresql(@RequestBody List<ConfigurationPostgresqlDTO> configurationPostgresqlDTOList) throws SQLException {

        for(ConfigurationPostgresqlDTO configurationPostgresqlDTO : configurationPostgresqlDTOList) {
            ConfigurationPostgresql configurationPostgresql = new ConfigurationPostgresql();
            configurationPostgresql.setId(configurationPostgresqlDTO.getId());
            configurationPostgresql.setKey(configurationPostgresqlDTO.getKey());
            configurationPostgresql.setValue(configurationPostgresqlDTO.getValue());
            configurationService.saveConfigurationPostgresql(configurationPostgresql);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/savehba")
    @Override
    public void saveConfigurationPghba(@RequestBody List<ConfigurationPghbaDTO> configurationPghbaDTOList) throws SQLException {

        for(ConfigurationPghbaDTO configurationPghbaDTO : configurationPghbaDTOList) {
            ConfigurationPghba configurationPghba = new ConfigurationPghba();
            configurationPghba.setId(configurationPghbaDTO.getId());
            configurationPghba.setType(configurationPghbaDTO.getType());
            configurationPghba.setDatabase(configurationPghbaDTO.getDatabase());
            configurationPghba.setUser(configurationPghbaDTO.getUser());
            configurationPghba.setAddress(configurationPghbaDTO.getAddress());
            configurationPghba.setMethod(configurationPghbaDTO.getMethod());
            configurationService.saveConfigurationPghba(configurationPghba);
        }
    }


    @GetMapping("/get")
    @Override
    public ConfigurationPostgresqlDTO getConfigurationWithID(@RequestParam int id) throws SQLException {

        ConfigurationPostgresql configurationPostgresql = configurationService.getConfigurationWithID(id);
        return new ConfigurationPostgresqlDTO(configurationPostgresql);
    }
}
