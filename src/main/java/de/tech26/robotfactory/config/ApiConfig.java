package de.tech26.robotfactory.config;

import de.tech26.robotfactory.dto.RobotStock;
import de.tech26.robotfactory.service.RobotInventoryService;
import de.tech26.robotfactory.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Class which is used to configure API
 *
 * @author Tarun Rohila
 */
@Configuration
public class ApiConfig {

    /**
     * Autowired dependency for {@link RobotInventoryService}
     */
    @Autowired
    RobotInventoryService robotInventoryService;

    /**
     * Method to load robot inventory from stock.json file
     */
    @PostConstruct
    public void loadRobotInventory() {
        RobotStock data = JsonUtils.loadJsonToObj("data/stock.json", RobotStock.class);
        robotInventoryService.loadRobotInventory(data);
    }

}
