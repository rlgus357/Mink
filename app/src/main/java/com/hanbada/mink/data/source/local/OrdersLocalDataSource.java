package com.hanbada.mink.data.source.local;

import android.support.annotation.NonNull;

import com.hanbada.mink.data.Order;
import com.hanbada.mink.data.source.OrdersDataSource;
import com.hanbada.mink.util.AppExecutors;

public class OrdersLocalDataSource implements OrdersDataSource{

    private static volatile OrdersLocalDataSource Instance;

    private OrdersDao mOrdersDao;

    private AppExecutors mAppExecutors;

    public OrdersLocalDataSource(@NonNull  OrdersDao mOrdersDao,@NonNull AppExecutors mAppExecutors) {
        this.mOrdersDao = mOrdersDao;
        this.mAppExecutors = mAppExecutors;
    }

    public static OrdersLocalDataSource getInstance(@NonNull AppExecutors appExecutors,
                                                    @NonNull OrdersDao ordersDao) {
        if(Instance == null){
            synchronized (OrdersLocalDataSource.class){
                if(Instance == null){
                    Instance = new OrdersLocalDataSource(ordersDao, appExecutors);
                }
            }
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
