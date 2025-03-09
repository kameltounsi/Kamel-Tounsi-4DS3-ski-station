package com.esprit.kameltounsi4ds3.Controllers;

import com.esprit.kameltounsi4ds3.entities.Registration;
import com.esprit.kameltounsi4ds3.entities.Subscription;
import com.esprit.kameltounsi4ds3.services.IRegistrationServices;
import com.esprit.kameltounsi4ds3.services.ISubscriptionServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("subscription")
@AllArgsConstructor
public class SubscriptionController {
    private ISubscriptionServices subscriptionServices;
    @PostMapping("add")
    public Subscription addSubscription(@RequestBody Subscription subscription) {
        return subscriptionServices.addSubscription(subscription);
    }
    @GetMapping("all")
    public List<Subscription> retrieveAll() {
        return subscriptionServices.retrieveAll();
    }

    @PutMapping("update")
    public Subscription updateSubscription(@RequestBody Subscription subscription)
    {
        return subscriptionServices.updateSubscription(subscription);
    }
    @GetMapping("get/{numSubscription}")
    public Subscription retrieveSubscription(@PathVariable Long numSubscription) {
        return subscriptionServices.retrieveSubscription(numSubscription);
    }
    @GetMapping("delete/{numSubscription}")
    public void removeSubscription(@PathVariable Long numSubscription)
    {
        subscriptionServices.removeSubscription(numSubscription);
    }
}
