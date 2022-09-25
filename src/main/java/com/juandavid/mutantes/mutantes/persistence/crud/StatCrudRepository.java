package com.juandavid.mutantes.mutantes.persistence.crud;

import com.juandavid.mutantes.mutantes.persistence.entity.StatEntity;
import org.springframework.data.repository.CrudRepository;

public interface StatCrudRepository extends CrudRepository<StatEntity, Integer> {
}
