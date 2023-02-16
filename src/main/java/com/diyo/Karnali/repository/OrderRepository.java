package com.diyo.Karnali.repository;

import com.diyo.Karnali.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "select * from order_tbl where fk_user_id =:id", nativeQuery = true)
    public List<Order> getUserOrderDetails(@Param("id") long id);

    @Query( value = "select sum(discounted_amount) from order_tbl where fk_user_id= :id",nativeQuery = true)
    public double getUserDiscountReceived(@Param("id") long id);

}
