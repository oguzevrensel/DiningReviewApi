package com.example.DiningReviewApi.diningreviewapi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    public void addNewUser(User user) {

        userRepository.save(user);
        System.out.println(user);
    }

    public void deleteUser(Long userId) {
        boolean existsUser = userRepository.existsById(userId);
        if (!existsUser) {
            throw new IllegalStateException("user with id " + userId + " does not exist");
        }
        userRepository.deleteById(userId);
    }

    public void updateUser(Long userId,
                           String userName,
                           String city,
                           String state,
                           String postCode
                           ) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("user with id " + userId + " does not exist"));

        if (userName != null && userName.length() > 0 && !Objects.equals(user.getUserName(), userName)) {
            user.setUserName(userName);
        }

        if (city != null && city.length() > 0 && !Objects.equals(user.getCity(), city)) {
            user.setCity(city);
        }

        if (state != null && state.length() > 0 && !Objects.equals(user.getState(), state)) {
            user.setState(state);
        }

        if (postCode != null && postCode.length() > 0 && !Objects.equals(user.getPostCode(), postCode)) {
            user.setPostCode(postCode);
        }
    }


}
