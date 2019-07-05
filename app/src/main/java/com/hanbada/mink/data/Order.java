package com.hanbada.mink.data;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "Orders")
public class Order {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name ="shopId")
    public final Long sId;

    @NonNull
    @ColumnInfo(name = "shopName")
    public final String mShopName;

    @NonNull
    @ColumnInfo(name = "paymentWaitCases")
    public final int mPaymentWaitCases;

    @NonNull
    @ColumnInfo(name = "newOrderCases")
    public final int mNewOrderCases;

    @NonNull
    @ColumnInfo(name = "deliveryPreparingCases")
    public final int mDeliveryPreparingCases;

    @NonNull
    @ColumnInfo(name = "deliveringCases")
    public final int mDeliveringCases;

    @NonNull
    @ColumnInfo(name = "deliveredCases")
    public final int mDeliveredCases;

    @NonNull
    public Long getId() {
        return sId;
    }

    @NonNull
    public String getmShopName() {
        return mShopName;
    }

    public int getmPaymentWaitCases() {
        return mPaymentWaitCases;
    }

    public int getmNewOrderCases() {
        return mNewOrderCases;
    }

    public int getmDeliveryPreparingCases() {
        return mDeliveryPreparingCases;
    }

    public int getmDeliveringCases() {
        return mDeliveringCases;
    }

    public int getmDeliveredCases() {
        return mDeliveredCases;
    }

    @ColumnInfo(name = "completed")
    public final boolean mCompleted;

    /**
     *
     * @param sId
     * @param mShopName
     * @param mPaymentWaitCases
     * @param mNewOrderCases
     * @param mDeliveryPreparingCases
     * @param mDeliveringCases
     * @param mDeliveredCases
     * @param mCompleted
     */
    public Order(@NonNull Long sId, @NonNull String mShopName, int mPaymentWaitCases, int mNewOrderCases, int mDeliveryPreparingCases, int mDeliveringCases, int mDeliveredCases, boolean mCompleted) {
        this.sId = sId;
        this.mShopName = mShopName;
        this.mPaymentWaitCases = mPaymentWaitCases;
        this.mNewOrderCases = mNewOrderCases;
        this.mDeliveryPreparingCases = mDeliveryPreparingCases;
        this.mDeliveringCases = mDeliveringCases;
        this.mDeliveredCases = mDeliveredCases;
        this.mCompleted = mCompleted;
    }

    public boolean isActive() {return !mCompleted;}
}
