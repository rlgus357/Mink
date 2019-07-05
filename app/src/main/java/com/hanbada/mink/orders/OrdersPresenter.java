package com.hanbada.mink.orders;

import android.support.annotation.NonNull;

import com.hanbada.mink.data.Order;
import com.hanbada.mink.data.source.OrdersDataSource;
import com.hanbada.mink.data.source.OrdersRepository;
import com.hanbada.mink.util.EspressoIdlingResource;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

class OrdersPresenter implements  OrdersContract.Presenter{

    private final OrdersRepository mOrdersRepository;

    private final OrdersContract.View mOrdersView;

    private boolean mFirstLoad = true;

    public OrdersPresenter(@NonNull OrdersRepository ordersRepository, @NonNull OrdersContract.View ordersView) {

        mOrdersRepository = checkNotNull(ordersRepository, "ordersRepository cannot be null");
        mOrdersView = checkNotNull(ordersView, "ordersView cannot be null!!");

        mOrdersView.setPresenter(this);

    }

    @Override
    public void start() {
        loadOrders(false);
    }

    @Override
    public void result(int requestCode, int resultCode){


    }
    @Override
    public void loadOrders(boolean forceUpdate) {

        loadOrders(forceUpdate || mFirstLoad, true);
        mFirstLoad = false;
    }

    private void loadOrders(boolean forceUpdate, final boolean showLoadingUI) {
        if(showLoadingUI){
            mOrdersView.setLoadingIndicator(true);
        }
        if (forceUpdate) {
            mOrdersRepository.refreshOrders();
        }

        // The network request might be handled in a different thread so make sure Espresso knows
        // that the app is busy until the response is handled.
        EspressoIdlingResource.increment(); // App is busy until further notice

        mOrdersRepository.getOrders(new OrdersDataSource.LoadOrdersCallback(){
            @Override
            public void onOrdersLoaded(List<Order> orders){
                List<Order> ordersToShow = new ArrayList<Order>();

                // This callback may be called twice, once for the cache and once for loading
                // the data from the server API, so we check before decrementing, otherwise
                // it throws "Counter has been corrupted!" exception.
                if(!EspressoIdlingResource.getIdlingResource().isIdleNow()){
                    EspressoIdlingResource.decrement(); // Set app as idle.
                }

                ordersToShow.addAll(orders); // 원본에서는 필터링에 따라 추가하는게 있었지만 ..여기선 그냥 처리한다.

                // The view may not be able to handle UI updates anymore
                if(!mOrdersView.isActive()){
                    return;
                }

                if(showLoadingUI){
                    mOrdersView.setLoadingIndicator(false);
                }

                processOrders(ordersToShow);

            }
        });

    }

    private void processOrders(List<Order> ordersToShow) {
        if(ordersToShow.isEmpty()){
            processEmptyOrders();
        } else{
            mOrdersView.showOrders(ordersToShow);

        }
    }

    private void processEmptyOrders() {
        mOrdersView.showNoOrders();
    }

    @Override
    public void addNewShopInfo() {
        mOrdersView.showAddOrders();

    }

    @Override
    public void openOrderDetails(@NonNull Order requestOrder) {

    }

    @Override
    public void deleteShopInfo() {

    }
}
