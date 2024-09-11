package br.sc.senac.pombo.model.repository;

import br.sc.senac.pombo.model.entity.Pruu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PruuRepository {

    List<Pruu> findByUserId(String userId);
}