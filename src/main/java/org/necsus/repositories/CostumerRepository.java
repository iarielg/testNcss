package org.necsus.repositories;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.necsus.entities.Costumer;

import java.util.List;

@ApplicationScoped
public class CostumerRepository {

    @Inject
    EntityManager entityManager;


    @Transactional
    public void createdCostumer(Costumer costumer){
        entityManager.persist(costumer);
    }

    @Transactional
    public void deletedCostumer(Costumer costumer){
        entityManager.remove(costumer);
    }

    @Transactional
    public List<Costumer> listCostumer(){
       List<Costumer> costumers = entityManager.createQuery("select p from Costumer p").getResultList();
        return costumers;
    }

    @Transactional
    public void updateCostumer(Costumer costumer){
        Costumer c = entityManager.find(Costumer.class, costumer.getId());

        if (c != null){
            c.setName(costumer.getName());
            c.setEmail(costumer.getEmail());
        }else {
            throw new EntityNotFoundException("El cliente con el id: " + costumer.getId() + " no existe");
        }
    }

}
