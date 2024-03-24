package ru.netology.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ProductRepository {

    @PersistenceContext
    private EntityManager manager;

    public List<String> getProductName(String name) {
        List<String> result =
                //template.queryForList(scriptFileName, Map.of("name", name), String.class);
                manager.createQuery("SELECT o.productName FROM Order o WHERE customer.name = :name")
                        .setParameter("name", name).getResultList();
        System.out.println(result);
        return result;
    }
}