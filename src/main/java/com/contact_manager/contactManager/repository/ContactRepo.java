package com.contact_manager.contactManager.repository;

import com.contact_manager.contactManager.entity.ContactEntity;
import com.contact_manager.contactManager.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactRepo extends CrudRepository<ContactEntity, Long> {
    List<ContactEntity> findByUser(UserEntity user);

}
