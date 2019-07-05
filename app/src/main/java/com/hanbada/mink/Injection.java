package com.hanbada.mink;


import android.content.Context;
import android.support.annotation.NonNull;

import com.hanbada.mink.data.source.OrdersRepository;
import com.hanbada.mink.data.source.local.MinkDatabase;
import com.hanbada.mink.data.source.local.OrdersLocalDataSource;
import com.hanbada.mink.data.source.remote.OrdersRemoteDataSource;
import com.hanbada.mink.util.AppExecutors;

import static com.google.common.base.Preconditions.checkNotNull;

public class Injection {

    public static OrdersRepository provideOrdersRepository(@NonNull Context context){
        checkNotNull(context);

        MinkDatabase database = MinkDatabase.getInstance(context);
        return OrdersRepository.getInstance(OrdersRemoteDataSource.getInstance(),
                OrdersLocalDataSource.getInstance(new AppExecutors(),
                        database.orderDao()));
    }
}
