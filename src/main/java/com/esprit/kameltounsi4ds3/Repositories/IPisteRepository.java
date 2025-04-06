package com.esprit.kameltounsi4ds3.Repositories;

import com.esprit.kameltounsi4ds3.entities.Color;
import com.esprit.kameltounsi4ds3.entities.Piste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPisteRepository extends JpaRepository<Piste, Long> {
    List<Piste> findByColor(Color color);
    List<Piste> findByNamePisteAndColor(String name, Color color);


}