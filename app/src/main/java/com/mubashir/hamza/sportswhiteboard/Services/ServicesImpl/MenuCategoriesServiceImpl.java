package com.mubashir.hamza.sportswhiteboard.Services.ServicesImpl;

import android.view.Menu;

import com.mubashir.hamza.sportswhiteboard.Services.MenuCategoriesService;

public class MenuCategoriesServiceImpl implements MenuCategoriesService {

    private static final String SELECT_SPORT = "Select Sport";
    private static final String BASKETBALL = "Basketball";
    private static final String BASEBALL = "Baseball";
    private static final String FOOTBALL = "Football";
    private static final String HOCKEY = "Hockey";
    private static final String SOCCER = "Soccer";
    private static final String VOLLEYBALL = "Volleyball";
    private static final String TENNIS = "Tennis";

    private static final int MENU_FULL_BASKETBALL = Menu.FIRST+1;
    private static final int MENU_HALF_BASKETBALL = Menu.FIRST+2;
    private static final int MENU_FULL_BASEBALL = Menu.FIRST+3;
    private static final int MENU_HALF_BASEBALL = Menu.FIRST+4;
    private static final int MENU_FULL_FOOTBALL = Menu.FIRST+5;
    private static final int MENU_HALF_FOOTBALL = Menu.FIRST+6;
    private static final int MENU_FULL_HOCKEY = Menu.FIRST+7;
    private static final int MENU_HALF_HOCKEY = Menu.FIRST+8;
    private static final int MENU_FULL_SOCCER = Menu.FIRST+9;
    private static final int MENU_HALF_SOCCER = Menu.FIRST+10;
    private static final int MENU_FULL_VOLLEYBALL = Menu.FIRST+11;
    private static final int MENU_HALF_VOLLEYBALL = Menu.FIRST+12;
    private static final int MENU_FULL_TENNIS = Menu.FIRST+13;
    private static final int MENU_HALF_TENNIS = Menu.FIRST+14;

    @Override
    public String getSelectSport() {
        return SELECT_SPORT;
    }

    @Override
    public String getBasketball() {
        return BASKETBALL;
    }

    @Override
    public String getBaseball() {
        return BASEBALL;
    }

    @Override
    public String getFootball() {
        return FOOTBALL;
    }

    @Override
    public String getSoccer() {
        return SOCCER;
    }

    @Override
    public String getVolleyball() {
        return VOLLEYBALL;
    }

    @Override
    public String getHockey() {
        return HOCKEY;
    }

    @Override
    public String getTennis() {
        return TENNIS;
    }

    @Override
    public int getMenuFullBasketball() {
        return MENU_FULL_BASKETBALL;
    }

    @Override
    public int getMenuHalfBasketball() {
        return MENU_HALF_BASKETBALL;
    }

    @Override
    public int getMenuFullBaseball() {
        return MENU_FULL_BASEBALL;
    }

    @Override
    public int getMenuHalfBaseball() {
        return MENU_HALF_BASEBALL;
    }

    @Override
    public int getMenuFullFootball() {
        return MENU_FULL_FOOTBALL;
    }

    @Override
    public int getMenuHalfFootball() {
        return MENU_HALF_FOOTBALL;
    }

    @Override
    public int getMenuFullHockey() {
        return MENU_FULL_HOCKEY;
    }

    @Override
    public int getMenuHalfHockey() {
        return MENU_HALF_HOCKEY;
    }

    @Override
    public int getMenuFullSoccer() {
        return MENU_FULL_SOCCER;
    }

    @Override
    public int getMenuHalfSoccer() {
        return MENU_HALF_SOCCER;
    }

    @Override
    public int getMenuFullVolleyball() {
        return MENU_FULL_VOLLEYBALL;
    }

    @Override
    public int getMenuHalfVolleyball() {
        return MENU_HALF_VOLLEYBALL;
    }

    @Override
    public int getMenuFullTennis() {
        return MENU_FULL_TENNIS;
    }

    @Override
    public int getMenuHalfTennis() {
        return MENU_HALF_TENNIS;
    }
}
