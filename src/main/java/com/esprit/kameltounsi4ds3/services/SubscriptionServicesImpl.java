package com.esprit.kameltounsi4ds3.services;

import com.esprit.kameltounsi4ds3.Repositories.ISubscriptionRepository;
import com.esprit.kameltounsi4ds3.entities.Subscription;
import com.esprit.kameltounsi4ds3.entities.TypeSubscription;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class SubscriptionServicesImpl implements ISubscriptionServices{
    private ISubscriptionRepository subscriptionRepository;
    @Override
    public Subscription addSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription updateSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription retrieveSubscription(Long numSubscription) {
        return subscriptionRepository.findById(numSubscription).orElse(null);
    }

    @Override
    public void removeSubscription(Long numSubscription) {
        subscriptionRepository.deleteById(numSubscription);
    }

    @Override
    public List<Subscription> retrieveAll() {
        return subscriptionRepository.findAll();
    }
    @Override
    public Set<Subscription> getSubscriptionByType(TypeSubscription type) {
        return subscriptionRepository.findByTypeSubOrderByStartDateAsc(type);
    }
    @Override
    public List<Subscription> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate) {
        return subscriptionRepository.getSubscriptionsByStartDateBetween(startDate, endDate);
    }



}
