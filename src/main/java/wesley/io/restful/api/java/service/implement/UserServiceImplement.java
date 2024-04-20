package wesley.io.restful.api.java.service.implement;

import org.springframework.stereotype.Service;
import wesley.io.restful.api.java.domain.model.User;
import wesley.io.restful.api.java.domain.repository.UserRepository;
import wesley.io.restful.api.java.service.UserService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImplement implements UserService {
    private final UserRepository userRepository;

    public UserServiceImplement(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(User user) {
        if (userRepository.existsByAccountAccountNumber(user.getAccount().getAccountNumber())) {
            throw new IllegalArgumentException("User account number already exists");
        }
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
