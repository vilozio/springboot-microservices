package org.webapp.service;

import org.webapp.entity.dto.UserDto;

public interface EmailService {

    void sendSimpleMessage(UserDto input);
}
