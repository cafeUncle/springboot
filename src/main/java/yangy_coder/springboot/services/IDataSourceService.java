package yangy_coder.springboot.services;

import yangy_coder.springboot.model.User;

import java.util.List;

public interface IDataSourceService {
    List<User> findUsersInOne();
    List<User> findUsersInTwo();
}
