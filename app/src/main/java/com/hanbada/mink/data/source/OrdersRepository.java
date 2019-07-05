package com.hanbada.mink.data.source;

import android.support.annotation.NonNull;

import com.hanbada.mink.data.Order;

import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

public class OrdersRepository implements OrdersDataSource{

    private static OrdersRepository Instance = null;

    private final OrdersDataSource mOrdersRemoteDataSource;

    private final OrdersDataSource mOrdersLocalDataSource;

    /**
     * This variable has package local visibility so it can be accessed from tests
     */
    Map<String, Order> mCachedOrders;

    /**
     * Marks the cache as invalid, to force an update the next time data is requested. this variable
     * has package local visibility so it can be accessed from tests.
     */
    boolean mCacheIsDirty = false;

    // Prevent direct instantiation.
    private OrdersRepository(@NonNull OrdersDataSource ordersRemoteDataSource,
                             @NonNull OrdersDataSource ordersLocalDatasource){
        mOrdersRemoteDataSource = checkNotNull(ordersRemoteDataSource);
        mOrdersLocalDataSource = checkNotNull(ordersLocalDatasource);
    }

    /**
     * Returns the single instance of this class, creating it if necessary.
     * @param ordersRemoteDataSource the backend data source
     * @param ordersLocalDataSource the device storage data source
     * @return the {@link OrdersRepository} instance
     */
    public static OrdersRepository getInstance(OrdersDataSource ordersRemoteDataSource,
                                               OrdersDataSource ordersLocalDataSource) {
        if (Instance == null) {
            Instance = new OrdersRepository(ordersRemoteDataSource, ordersLocalDataSource);
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
