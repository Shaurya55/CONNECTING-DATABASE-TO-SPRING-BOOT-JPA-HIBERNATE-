package com.databaseconnect.databasespring.dao;

import com.databaseconnect.databasespring.models.entry;
import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;

public interface userrepo extends CrudRepository<entry,Integer> {
}
