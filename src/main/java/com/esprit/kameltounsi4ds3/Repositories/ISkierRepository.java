package com.esprit.kameltounsi4ds3.Repositories;

import com.esprit.kameltounsi4ds3.entities.Skier;
import com.esprit.kameltounsi4ds3.entities.TypeSubscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISkierRepository extends JpaRepository<Skier,Long> {
    List<Skier> findBySubscriptionTypeSub(TypeSubscription type);

}
