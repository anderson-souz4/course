package com.github.course.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.course.entities.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_order")
@Data
@NoArgsConstructor
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    private Integer orderStatus;

    /**
     * Relacionamento Muitos para Um, muitos pedidos para um cliente
     * A anotação JoinColumn está dizendo que a chave primaria do relacionamento é cliente_id
     */
    @ManyToOne()
    @JoinColumn(name = "cliente_id")
    private User client;

    public Order(Long id, Instant moment, OrderStatus OrderStatus, User client) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(OrderStatus);
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id.equals(order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null) {
            this.orderStatus = orderStatus.getCode();
        }
    }
}
