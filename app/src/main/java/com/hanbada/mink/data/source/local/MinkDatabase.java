package com.hanbada.mink.data.source.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.hanbada.mink.data.Order;

@Database(entities = {Order.class}, version = 1)
public abstract class MinkDatabase extends RoomDatabase {

    private static MinkDatabase Instance;

    public abstract OrdersDao orderDao();

    private static final Object sLock = new Object();

    public static MinkDatabase getInstance(Context context) {
        synchronized (sLock){
            if(Instance == null){
                Instance = Room.databaseBuilder(context.getApplicationContext(),
                        MinkDatabase.class, "Orders.db")
                        .build();
            }
            return Instance;
        }
    }
}
