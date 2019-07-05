package com.hanbada.mink.util;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 *  This provides methods to help Activities load their UI.
 */
public class ActivityUtils {

    /**
     *
     * @param fragmentManager The operations is performed by the framgentManager
     * @param fragment  fragment is added to the container view with id frameId
     * @param frameId   fragmentId
     */
    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                             @NonNull Fragment fragment, int frameId){

        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment);
        transaction.commit();
    }
}
