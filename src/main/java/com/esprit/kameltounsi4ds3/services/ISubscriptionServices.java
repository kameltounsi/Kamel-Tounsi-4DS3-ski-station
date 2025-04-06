package com.esprit.kameltounsi4ds3.services;

import com.esprit.kameltounsi4ds3.entities.Subscription;
import com.esprit.kameltounsi4ds3.entities.TypeSubscription;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface ISubscriptionServices {
    Subscription addSubscription(Subscription subscription);
    Subscription updateSubscription(Subscription subscription);
    Subscription retrieveSubscription(Long numSubscription);
    void removeSubscription(Long numSubscription);
    List<Subscription> retrieveAll();

    Set<Subscription> getSubscriptionByType(TypeSubscription type);

    List<Subscription> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate);
}