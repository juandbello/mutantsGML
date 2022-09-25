package com.juandavid.mutantes.mutantes.domain.services;

import com.juandavid.mutantes.mutantes.domain.dto.StatDto;
import com.juandavid.mutantes.mutantes.domain.repository.StatRepositoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatService {

    @Autowired
    private StatRepositoryDto statRepositoryDto;

    private Double calculateRatio(StatDto statDto){
        Double ratio;
        try{
            ratio = Double.valueOf(statDto.getCountMutant()) / Double.valueOf(statDto.getCountHumanDna());
        }catch (Exception ex){
            ratio = 0.0;
        }
        return  ratio;
    }
    public StatDto getStat(){
        StatDto statDto = statRepositoryDto.getStat();
        statDto.setRatio(calculateRatio(statDto));
        return statDto;
    }
    public StatDto save(boolean isMutant){
        StatDto statDto = statRepositoryDto.save(isMutant);
        statDto.setRatio(calculateRatio(statDto));
        return statDto;
    }
}
