package yte.pgman.controller;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yte.pgman.controller.dto.ConfigurationDTO;
import yte.pgman.repository.pojo.Configuration;
import yte.pgman.service.ConfigurationService;

import java.sql.SQLException;
import java.util.List;


@RestController
@RequestMapping("/configuration")
public class ConfigurationControllerImpl implements ConfigurationController {

    @Autowired
    private ConfigurationService configurationService;

    @PostMapping("/save")
    @Override
    public void saveConfiguration(@RequestBody List<ConfigurationDTO> configurationDTOList) throws SQLException {

        for(ConfigurationDTO configurationDTO: configurationDTOList) {
            Configuration configuration = new Configuration(configurationDTO.getConfigurationID(), configurationDTO.getConfigurationKey(), configurationDTO.getConfigurationValue());
            configurationService.saveConfiguration(configuration);
        }
//        Configuration configuration = new Configuration(configurationDTO.getConfigurationID(), configurationDTO.getConfigurationKey(), configurationDTO.getConfigurationValue());
//        configurationService.saveConfiguration(configuration);
    }


    @GetMapping("/conf")
    @Override
    public ConfigurationDTO getConfigurationWithID(@RequestParam int id) throws SQLException {

        Configuration configuration = configurationService.getConfigurationWithID(id);
        return new ConfigurationDTO(configuration);
    }
}
