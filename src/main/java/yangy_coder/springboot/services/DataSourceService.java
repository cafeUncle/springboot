package yangy_coder.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yangy_coder.springboot.dao.UserDao;
import yangy_coder.springboot.model.User;

import java.util.List;

@Service
public class DataSourceService implements IDataSourceService{

    @Autowired
    UserDao userDao;

    @Override
    public List<User> findUsersInOne() {
        return userDao.findUsersInOne();
    }

    @Override
    public List<User> findUsersInTwo() {
        return userDao.findUsersInSecond();
    }
}
