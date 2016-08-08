package org.segin.busflagger;

import android.graphics.Color;
import android.content.Context;

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

    public int getRouteColor() {
        return routeColor;
    }

    public void setRouteColor(int routeColor) {
        this.routeColor = routeColor;
    }

    private String routeNumber;
    private String routeName;
    private int routeColor;
    private Context context;

    public Routes() {

    }

    private int translateColor(String color) {
        switch (color) {
            case "Lime":
                return context.getResources().getColor(R.color.route_Lime);
            case "Orange":
                return context.getResources().getColor(R.color.route_Orange);
            case "Blue":
                return context.getResources().getColor(R.color.route_Blue);
            case "Black":
                return context.getResources().getColor(R.color.route_Black);
            case "Red":
                return context.getResources().getColor(R.color.route_Red);
            case "Yellow":
                return context.getResources().getColor(R.color.route_Yellow);
            case "Maroon":
                return context.getResources().getColor(R.color.route_Maroon);
            case "Brown":
                return context.getResources().getColor(R.color.route_Brown);
            case "Aqua":
                return context.getResources().getColor(R.color.route_Aqua);
            case "Purple":
                return context.getResources().getColor(R.color.route_Purple);
            case "Pink":
                return context.getResources().getColor(R.color.route_Pink);
            case "Green":
            default:
                return context.getResources().getColor(R.color.route_Green);
        }
    }

    public Routes(String number, String name, int color) {
        routeNumber = number;
        routeName = name;
        routeColor = color;
        context = null;
    }

    public Routes(Context context, String route) {
        this.context = context;
        String[] elems = route.split("-");
        routeNumber = elems[0].trim();
        routeName = elems[1].trim();
        routeColor = translateColor(elems[2].trim());
    }

}
