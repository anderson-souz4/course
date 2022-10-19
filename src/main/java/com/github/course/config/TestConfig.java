package com.github.course.config;

import com.github.course.entities.Category;
import com.github.course.entities.Order;
import com.github.course.entities.User;
import com.github.course.entities.enums.OrderStatus;
import com.github.course.repositories.CategoryRepository;
import com.github.course.repositories.OrderRepository;
import com.github.course.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
@RequiredArgsConstructor
public class TestConfig implements CommandLineRunner {

    private final UserRepository repository;
    private final OrderRepository orderRepository;

    private final CategoryRepository categoryRepository;




    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");
        categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));


        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "999999", "12345");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "888888", "12345");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.WAITING_PAYMENT, u1);


        repository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
    }
}
