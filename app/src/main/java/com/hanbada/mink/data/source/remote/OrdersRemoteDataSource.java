package com.hanbada.mink.data.source.remote;

import android.support.annotation.NonNull;

import com.hanbada.mink.data.Order;
import com.hanbada.mink.data.source.OrdersDataSource;

import java.util.LinkedHashMap;
import java.util.Map;

public class OrdersRemoteDataSource implements OrdersDataSource {

    private static OrdersRemoteDataSource Instance;

    private static final int SERVICE_LATENCY_IN_MILLIS = 5000;

    private final static Map<String, Order> ORDERS_SERVICE_DATA;

    static{
        ORDERS_SERVICE_DATA = new LinkedHashMap<>(2);

    }

    public static OrdersDataSource getInstance() {
        if(Instance == null){
            Instance = new OrdersRemoteDataSource();
        }
        return Instance;
    }

    @Override
    public void getOrders(@NonNull LoadOrdersCallback callback) {

    }

    @Override
    public void refreshOrders() {

    }
}
