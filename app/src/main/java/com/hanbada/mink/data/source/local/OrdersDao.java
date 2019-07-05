package com.hanbada.mink.data.source.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.hanbada.mink.data.Order;

import java.util.List;

@Dao
public interface OrdersDao {

    @Query("SELECT * FROM Orders")
    List<Order> getTasks();


    @Query("SELECT * FROM Orders WHERE shopId = :orderId")
    Order getOrderById(String orderId);
}
