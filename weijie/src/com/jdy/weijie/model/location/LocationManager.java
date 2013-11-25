package com.jdy.weijie.model.location;

import android.content.Context;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.jdy.weijie.model.BaseManger;

/**
 * Created with IntelliJ IDEA.
 * User: yc
 * Date: 11/25/13
 * Time: 11:44 PM
 */
public class LocationManager extends BaseManger {
    private static Location lastLocation;
    private LocationClient locationClient;
    private LocationManagerListener locationManagerListener;

    public LocationManager(Context context) {
        super(context);

        LocationClientOption option = new LocationClientOption();
        option.setCoorType("bd09ll");
        option.setAddrType("all");
        option.setOpenGps(true);

        locationClient = new LocationClient(context);
        locationClient.setLocOption(option);

        locationClient.registerLocationListener(new BDLocationListener() {
            @Override
            public void onReceiveLocation(BDLocation bdLocation) {
                lastLocation = new Location();
                lastLocation.setAddress(bdLocation.getAddrStr());
                lastLocation.setLatitude(bdLocation.getLatitude());
                lastLocation.setLongitude(bdLocation.getLongitude());
                lastLocation.setCity(bdLocation.getCity());

                if(locationManagerListener != null){
                    locationManagerListener.onReceiveLocation(lastLocation);
                }
            }

            @Override
            public void onReceivePoi(BDLocation bdLocation) {

            }
        });


    }

    public Location getLastLocation() {
        return lastLocation;
    }

    public void requestLocation(LocationManagerListener listener) {
        locationManagerListener = listener;

        locationClient.start();
        locationClient.requestLocation();
    }

    public interface LocationManagerListener {

        public void onReceiveLocation(Location location);
    }
}
