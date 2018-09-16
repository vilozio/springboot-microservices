package org.webapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.webapp.entity.Mail;

public interface MailRepository extends CrudRepository<Mail, Long> {
}