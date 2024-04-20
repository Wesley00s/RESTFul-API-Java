package wesley.io.restful.api.java.service;

import wesley.io.restful.api.java.domain.model.User;

import java.util.List;

public interface UserService {
    User findById(Long id);
    List<User> findAll();
    User create(User user);
    User update(User user);
    void delete(Long id);
}
