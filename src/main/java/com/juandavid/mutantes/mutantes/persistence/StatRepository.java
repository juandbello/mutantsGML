package com.juandavid.mutantes.mutantes.persistence;

import com.juandavid.mutantes.mutantes.domain.dto.StatDto;
import com.juandavid.mutantes.mutantes.domain.repository.StatRepositoryDto;
import com.juandavid.mutantes.mutantes.persistence.crud.StatCrudRepository;
import com.juandavid.mutantes.mutantes.persistence.entity.StatEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StatRepository implements StatRepositoryDto {

    @Autowired
    private StatCrudRepository statCrudRepository;


    private StatDto mapper(StatEntity statEntity){
        StatDto statDto = new StatDto();
        statDto.setId(statEntity.getId());
        statDto.setCountHumanDna(statEntity.getCountHumanDna());
        statDto.setCountMutant(statEntity.getCountMutant());

        return statDto;
    }
    @Override
    public StatDto getStat() {
        StatEntity statEntity = statCrudRepository.findAll().iterator().next();
        StatDto statDto = mapper(statEntity);

        return statDto;
    }

    @Override
    public StatDto save(boolean isMutant) {
        StatEntity statEntity = statCrudRepository.findAll().iterator().next();
        statEntity.setCountHumanDna(isMutant ? statEntity.getCountHumanDna() : statEntity.getCountHumanDna() + 1);
        statEntity.setCountMutant(isMutant ? statEntity.getCountMutant() + 1 : statEntity.getCountMutant());
        StatEntity newStatEntity = statCrudRepository.save(statEntity);

        StatDto statDto = mapper(newStatEntity);
        return statDto;
    }
}
