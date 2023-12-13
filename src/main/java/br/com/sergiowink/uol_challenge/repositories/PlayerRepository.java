package br.com.sergiowink.uol_challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sergiowink.uol_challenge.entity.PlayerEntity;


@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {
    
}
