package com.hanbada.mink.orders;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.hanbada.mink.Injection;
import com.hanbada.mink.R;
import com.hanbada.mink.util.ActivityUtils;
import com.hanbada.mink.util.BackPressCloseHandler;

/**
 *  참조 : https://github.com/googlesamples/android-architecture
 *
 */
public class OrderActivity extends AppCompatActivity {

    private OrdersPresenter mOrdersPresenter;

    private BackPressCloseHandler backPressCloseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orders_activity);

        this.setupViewItem();
        this.setupConfiguration(savedInstanceState);


    }
    private void setupViewItem() {

        backPressCloseHandler = new BackPressCloseHandler(this);
//        backPressCloseHandler.onBackPressed();

        // Set up the toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        ActionBar ab = getSupportActionBar();
//        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
//        ab.setDisplayHomeAsUpEnabled(true);


    }

    private void setupConfiguration(Bundle savedInstanceState) {

        OrdersFragment ordersFragment = (OrdersFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if(ordersFragment == null){
            // Create the fragment
            ordersFragment = OrdersFragment.newInstance();
            ActivityUtils.addFragmentToActivity( getSupportFragmentManager(), ordersFragment, R.id.contentFrame );

        }

        // Create the presenter
        mOrdersPresenter = new OrdersPresenter(
                Injection.provideOrdersRepository(getApplicationContext()), ordersFragment);

    }
    @Override
    public void onBackPressed() {
        backPressCloseHandler.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.home :
                // nothing
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}



