package org.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.bootstrap.config.PropertySourceBootstrapProperties;
import org.springframework.stereotype.Service;
import org.webapp.entity.User;
import org.webapp.kafka.producer.Sender;
import org.webapp.repository.UserRepository;

@Service
@EnableConfigurationProperties(PropertySourceBootstrapProperties.class)
public class UserServiceImpl implements UserService {

    @Value("${spring.kafka.topic.userCreated}")
    private static String USER_CREATED_TOPIC;

    private UserRepository userRepository;
    private Sender sender;

    @Autowired
    UserServiceImpl(UserRepository userRepository, Sender sender) {
        this.userRepository = userRepository;
        this.sender = sender;
    }

    @Override
    public User registerUser(User input) {
        User createdUser = userRepository.save(input);
        sender.send(USER_CREATED_TOPIC, createdUser);
        return createdUser;
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
}
