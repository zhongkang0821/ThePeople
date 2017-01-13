package com.library.base;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.Fragment;

public class BaseFragment extends Fragment {
    public boolean getConnect(Context context){
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager.getActiveNetworkInfo()!=null){
            boolean flag = manager.getActiveNetworkInfo().isAvailable();
            if (flag){
                NetworkInfo.State state = manager.getActiveNetworkInfo().getState();
                if (state == NetworkInfo.State.CONNECTED){
                    return true;
                }
            }
        }
        return false;
    }
}
