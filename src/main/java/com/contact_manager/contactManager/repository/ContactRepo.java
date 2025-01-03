package com.contact_manager.contactManager.repository;

import com.contact_manager.contactManager.entity.ContactEntity;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepo extends CrudRepository<ContactEntity, Long> {
}
