package com.scoober.util;

import com.scoober.model.Location;

public class ETAUtil {
    public static double haversineKm(double lat1, double lng1, double lat2, double lng2) {
        double R = 6371;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lng2 - lng1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2)
                 + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                 * Math.sin(dLng/2) * Math.sin(dLng/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return R * c;
    }

    public static int estimateEtaMinutes(Location from, Location to) {
        double distance = haversineKm(from.getLat(), from.getLng(), to.getLat(), to.getLng());
        double speedKmH = 25.0;
        return (int) Math.round((distance / speedKmH) * 60);
    }
}
