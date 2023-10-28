package com.NoDeadlines.SoftUniFestApp2023.repositories;

import com.NoDeadlines.SoftUniFestApp2023.models.BusinessUser;
import com.NoDeadlines.SoftUniFestApp2023.models.Product;
import com.NoDeadlines.SoftUniFestApp2023.repositories.contratcts.ProductRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@PropertySource("classpath:application.properties")
public class ProductRepositoryImpl implements ProductRepository {

    private final SessionFactory sessionFactory;
@Autowired
    public ProductRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Product> getProducts(int amount) {
        try (Session session = sessionFactory.openSession()) {
        NativeQuery<Product> query = session.createNativeQuery("SELECT * \n" +
                "FROM product LIMIT 7; " )   ;
        return query.getResultList();
    }
}




}
