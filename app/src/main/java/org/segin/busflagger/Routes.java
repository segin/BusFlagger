package org.segin.busflagger;

import android.graphics.Color;

public class Routes {
    public String getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public Color getRouteColor() {
        return routeColor;
    }

    public void setRouteColor(Color routeColor) {
        this.routeColor = routeColor;
    }

    private String routeNumber;
    private String routeName;
    private Color routeColor;

    public Routes() {

    }

    public Routes(String number, String name, Color color) {
        routeNumber = number;
        routeName = name;
        routeColor = color;
    }


}
