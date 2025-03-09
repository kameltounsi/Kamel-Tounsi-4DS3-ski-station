package com.esprit.kameltounsi4ds3.services;

import com.esprit.kameltounsi4ds3.entities.Subscription;

import java.util.List;

public interface ISubscriptionServices {
    Subscription addSubscription(Subscription subscription);
    Subscription updateSubscription(Subscription subscription);
    Subscription retrieveSubscription(Long numSubscription);
    void removeSubscription(Long numSubscription);
    List<Subscription> retrieveAll();
}