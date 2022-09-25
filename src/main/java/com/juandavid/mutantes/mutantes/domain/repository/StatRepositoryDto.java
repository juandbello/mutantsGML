package com.juandavid.mutantes.mutantes.domain.repository;

import com.juandavid.mutantes.mutantes.domain.dto.StatDto;

public interface StatRepositoryDto {
    StatDto getStat();
    StatDto save(boolean isMutant);
}
