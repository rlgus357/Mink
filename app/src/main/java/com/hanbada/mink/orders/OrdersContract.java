package com.hanbada.mink.orders;

import android.support.annotation.NonNull;

import com.hanbada.mink.BasePresenter;
import com.hanbada.mink.BaseView;
import com.hanbada.mink.data.Order;

import java.util.List;

public interface OrdersContract {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        void showOrders(List<Order> orders);

        void showOrderDetail(String shopName);

        void showLoadingOrdersError();

        void showNoOrders();

        void showSuccessfullyCralwerMessage();


        void showAddOrders();

        boolean isActive();
    }

    interface Presenter extends BasePresenter {

        void result(int requestCode, int resultCode);

        void loadOrders(boolean forceUpdate);

        void addNewShopInfo();

        void openOrderDetails(@NonNull Order requestOrder);

        void deleteShopInfo();

    }
}
