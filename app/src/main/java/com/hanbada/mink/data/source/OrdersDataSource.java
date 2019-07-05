package com.hanbada.mink.data.source;

import android.support.annotation.NonNull;

import com.hanbada.mink.data.Order;

import java.util.List;

public interface OrdersDataSource {



    interface LoadOrdersCallback{

        void onOrdersLoaded(List<Order> orders);
    }

    interface GetOrderCallback{

        void onOrdersLoaded(Order order);

    }

    void getOrders(@NonNull LoadOrdersCallback callback);
//
//    void getOrder(@NonNull String orderId, @NonNull GetOrderCallback callback);

//    void saveOrder(@NonNull Order order);
//
//    void completeOrder(@NonNull Order order);
//
//    void completeOrder(@NonNull String orderId);
//
//    void activateOrder(@NonNull Order order);
//
//    void activateOrder(@NonNull String orderId);
//
//    void clearCompletedOrders();
//
    void refreshOrders();

    //void deleteAllOrders();

    //void deleteOrder(@NonNull String orderId);
}
