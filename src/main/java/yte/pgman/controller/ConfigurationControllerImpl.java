package yte.pgman.controller;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yte.pgman.controller.dto.ConfigurationDTO;
import yte.pgman.repository.pojo.Configuration;
import yte.pgman.service.ConfigurationService;

import java.util.List;


@RestController
@RequestMapping("/configuration")
public class ConfigurationControllerImpl implements ConfigurationController {

    private final ConfigurationService configurationService;

    @Autowired
    public ConfigurationControllerImpl(ConfigurationService configurationService) {
        this.configurationService = configurationService;
    }

    @PostMapping("/save")
    @Override
    public void saveConfiguration(@RequestBody List<ConfigurationDTO> configurationDTOList) {

        for(ConfigurationDTO configurationDTO: configurationDTOList) {
            Configuration configuration = new Configuration();
            BeanUtils.copyProperties(configurationDTO, configuration);
            configurationService.saveConfiguration(configuration);
        }
    }


    @GetMapping("/conf")
    @Override
    public ConfigurationDTO getConfigurationWithID(@RequestParam int id) {

        Configuration configuration = configurationService.getConfigurationWithID(id);
        return new ConfigurationDTO(configuration);
    }
}
