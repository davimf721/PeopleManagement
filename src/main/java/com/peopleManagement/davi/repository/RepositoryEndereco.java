package com.peopleManagement.davi.repository;

import com.peopleManagement.davi.repository.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryEndereco extends JpaRepository<EnderecoEntity, Long> {

}
