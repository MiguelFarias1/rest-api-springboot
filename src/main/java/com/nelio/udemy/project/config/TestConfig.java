package com.nelio.udemy.project.config;

import com.nelio.udemy.project.entities.*;
import com.nelio.udemy.project.entities.enumns.OrderStatus;
import com.nelio.udemy.project.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableJpaRepositories({"com.nelio.udemy.project.repositories"})
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private final UserRepository userRepository;

    private final OrderRepository orderRepository;

    private final CategoryRepository categoryRepository;

    private final ProductReposityory productReposityory;

    private final OrderItemRepository orderItemRepository;

    public TestConfig(final ProductReposityory productReposityory, final UserRepository userRepository,
                      final OrderRepository orderRepository, final CategoryRepository categoryRepository,
                      final OrderItemRepository orderItemRepository) {
        this.productReposityory = productReposityory;
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public void run(String... args) {

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

        p1.getCategories().add(cat2);

        p2.getCategories().add(cat1);

        p2.getCategories().add(cat3);

        p3.getCategories().add(cat2);

        productReposityory.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));

        var instant = Instant.now().minus(2, ChronoUnit.HOURS);

        Payment payment = new Payment(instant, o1);

        o1.setPayment(payment);

        orderRepository.save(o1);
    }
}
