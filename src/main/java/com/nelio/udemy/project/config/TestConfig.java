package com.nelio.udemy.project.config;

import com.nelio.udemy.project.entities.Category;
import com.nelio.udemy.project.entities.Order;
import com.nelio.udemy.project.entities.Product;
import com.nelio.udemy.project.entities.User;
import com.nelio.udemy.project.entities.enumns.OrderStatus;
import com.nelio.udemy.project.repositories.CategoryRepository;
import com.nelio.udemy.project.repositories.OrderRepository;
import com.nelio.udemy.project.repositories.ProductReposityory;
import com.nelio.udemy.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductReposityory productReposityory;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User("Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User("Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(List.of(u1,u2));

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.DELIVERED, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.CANCELED, u1);

        orderRepository.saveAll(List.of(o1,o2,o3));

        Category cat1 = new Category( "Electronics");
        Category cat2 = new Category( "Books");
        Category cat3 = new Category("Computers");

        categoryRepository.saveAll(List.of(cat1,cat2,cat3));

        Product p1 = new Product("The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", BigDecimal.valueOf(90.5), "");
        Product p2 = new Product( "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", BigDecimal.valueOf(2190.0), "");
        Product p3 = new Product( "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", BigDecimal.valueOf(1250.0), "");
        Product p4 = new Product( "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", BigDecimal.valueOf(1250.0), "");
        Product p5 = new Product( "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", BigDecimal.valueOf(100.99), "");

        productReposityory.saveAll(List.of(p1,p2,p3,p4,p5));
    }
}
