package com.esprit.kameltounsi4ds3.Repositories;

import com.esprit.kameltounsi4ds3.entities.Subscription;
import com.esprit.kameltounsi4ds3.entities.TypeSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface ISubscriptionRepository extends JpaRepository<Subscription, Long> {
    Set<Subscription> findByTypeSubOrderByStartDateAsc(TypeSubscription typeSub);
    List<Subscription> getSubscriptionsByStartDateBetween(LocalDate date1, LocalDate date2);

}
