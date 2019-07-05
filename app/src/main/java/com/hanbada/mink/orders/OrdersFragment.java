package com.hanbada.mink.orders;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hanbada.mink.R;
import com.hanbada.mink.data.Order;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Display
 */
public class OrdersFragment extends Fragment implements  OrdersContract.View {

    private OrdersContract.Presenter mPresenter;

    private OrdersAdapter mListAdapter;

    private View mNoOrdersView;

    private ImageView mNoOrderIcon;

    private LinearLayout mOrdersView;


    public OrdersFragment(){
        // Requires empty public constructor
    }

    public static OrdersFragment newInstance() {
        return new OrdersFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mListAdapter = new OrdersAdapter(new ArrayList<Order>(0), mItemListener);


    }

    /**
     * Listener for clicks on tasks in the ListView.
     */
    OrderItemListener mItemListener = new OrderItemListener() {
        @Override
        public void onOrderClick(Order clickedOrder) {
//            mPresenter.openOrderDetils(clickedOrder);
        }

        @Override
        public void onCompleteOrderClick(Order completedOrder) {
//            mPresenter.completeOrder(completedOrder);
        }

        @Override
        public void onActivateOrderClick(Order activatedOrder) {
//            mPresenter.activateOrder(activatedOrder);
        }
    };


    @Override
    public void setLoadingIndicator(final boolean active) {

        if(getView() == null){
            return;
        }
        final SwipeRefreshLayout srl = (SwipeRefreshLayout) getView().findViewById(R.id.refresh_layout);

        srl.post(new Runnable() {
            @Override
            public void run() {
                    srl.setRefreshing(active);
            }
        });
    }

    @Override
    public void showOrders(List<Order> orders) {
        mListAdapter.replaceData(orders);

        mOrdersView.setVisibility(View.VISIBLE);
        mNoOrdersView.setVisibility(View.GONE);

    }

    @Override
    public void showOrderDetail(String shopName) {

    }

    @Override
    public void showLoadingOrdersError() {

    }

    @Override
    public void showNoOrders() {

    }

    @Override
    public void showSuccessfullyCralwerMessage() {

    }

    @Override
    public void showAddOrders() {

    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public void setPresenter(OrdersContract.Presenter presenter) {

    }


    private static class OrdersAdapter extends BaseAdapter {

        private List<Order>  mOrders;
        private OrderItemListener mItemListener;

        public OrdersAdapter(List<Order> orders, OrderItemListener itemListener){
            this.setList(orders);
            mItemListener = itemListener;
        }

        public void replaceData(List<Order> orders){
            setList(orders);
            notifyDataSetChanged();
        }
        private void setList(List<Order> orders){ mOrders = checkNotNull(orders);}

        @Override
        public int getCount() {
            return mOrders.size();
        }

        @Override
        public Order getItem(int position) {
            return mOrders.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View rowView = convertView;
            if (rowView == null) {
                LayoutInflater infalter = LayoutInflater.from(parent.getContext());
                rowView = infalter.inflate(R.layout.order_item, parent, false);
            }

            final Order order = getItem(position);

            TextView titleTV = (TextView) rowView.findViewById(R.id.title);
//            titleTV.setText(order.getTitleForList());

            CheckBox completeCB = (CheckBox) rowView.findViewById(R.id.complete);

            // Active/completed task UI
            // 잠시 보류..
//            completeCB.setChecked(order.isCompleted());
//            if (order.isCompleted()) {
//                rowView.setBackgroundDrawable(parent.getContext().getResources().getDrawable(R.drawable.list_completed_touch_feedback));
//            } else {
//                rowView.setBackground(parent.getContext().getResources().getDrawable(R.drawable.touch_feedback));
//            }

//            completeCB.setOnClickListener(new View.OnClickListener(){
//                @Override
//                public void onClick(View v){
//                    if(!order.isCompleted()){
//                        mItemListener.onCompleteOrderClick(order);
//                    }else{
//                        mItemListener.onActivateOrderClick(order);
//                    }
//                }
//            });

            rowView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    mItemListener.onOrderClick(order);
                }
            });
            return rowView;
        }
    }



    public interface OrderItemListener{

        void onOrderClick(Order clickedOrder);

        void onCompleteOrderClick(Order completedOrder);

        void onActivateOrderClick(Order activatedOrder);
    }
}
