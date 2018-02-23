package yangy_coder.springboot.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yangy_coder.springboot.model.User;
import yangy_coder.springboot.services.DataSourceService;
import yangy_coder.springboot.services.IDataSourceService;

import java.util.List;

@RestController
public class DataSourceController {

    @Autowired
    IDataSourceService dataSourceService;

    @RequestMapping("/1/users")
    public List<User> users1() {
        return dataSourceService.findUsersInOne();
    }

    @RequestMapping("/2/users")
    public List<User> users2() {
        return dataSourceService.findUsersInTwo();
    }
}
