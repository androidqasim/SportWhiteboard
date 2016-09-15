package com.mubashir.hamza.sportswhiteboard.Activitys;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import com.mubashir.hamza.sportswhiteboard.R;
import com.mubashir.hamza.sportswhiteboard.Services.ServicesImpl.MenuCategoriesServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Menu_Activity extends AppCompatActivity {

    private List<Integer> viewIDS;
    private Typeface font_three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarMenu);
        setSupportActionBar(toolbar);

        TextView titleBarText = (TextView) getTitleTextView(toolbar);
        font_three = Typeface.createFromAsset(getAssets(), "font_three.ttf");
        titleBarText.setTypeface(font_three);
        titleBarText.setTextSize(TypedValue.COMPLEX_UNIT_SP, (getResources().getDimension(R.dimen.title)*1.5f));
        titleBarText.setTextColor(ContextCompat.getColor(this, R.color.title_menu));

        createTextViews();
    }

    private void createTextViews() {
        viewIDS = new ArrayList<>(7);

        final Typeface font_one = Typeface.createFromAsset(getAssets(), "font_one.otf");

        TextView selectSport = (TextView) findViewById(R.id.selectSport);
        selectSport.setText(new MenuCategoriesServiceImpl().getSelectSport());
        selectSport.setTypeface(font_three);

        TextView basketball = (TextView) findViewById(R.id.basketball);
        basketball.setText(new MenuCategoriesServiceImpl().getBasketball());
        basketball.setTypeface(font_one);
        viewIDS.add(basketball.getId());

        TextView baseball = (TextView) findViewById(R.id.baseball);
        baseball.setText(new MenuCategoriesServiceImpl().getBaseball());
        baseball.setTypeface(font_one);
        viewIDS.add(baseball.getId());

        TextView football = (TextView) findViewById(R.id.football);
        football.setText(new MenuCategoriesServiceImpl().getFootball());
        football.setTypeface(font_one);
        viewIDS.add(football.getId());

        TextView hockey = (TextView) findViewById(R.id.hockey);
        hockey.setText(new MenuCategoriesServiceImpl().getHockey());
        hockey.setTypeface(font_one);
        viewIDS.add(hockey.getId());

        TextView soccer = (TextView) findViewById(R.id.soccer);
        soccer.setText(new MenuCategoriesServiceImpl().getSoccer());
        soccer.setTypeface(font_one);
        viewIDS.add(soccer.getId());

        TextView volleyball = (TextView) findViewById(R.id.volleyball);
        volleyball.setText(new MenuCategoriesServiceImpl().getVolleyball());
        volleyball.setTypeface(font_one);
        viewIDS.add(volleyball.getId());

        TextView tennis = (TextView) findViewById(R.id.tennis);
        tennis.setText(new MenuCategoriesServiceImpl().getTennis());
        tennis.setTypeface(font_one);
        viewIDS.add(tennis.getId());
    }

    public void onSelectSport(View view) {

        Intent whiteBoard = new Intent(getBaseContext(), Whiteboard_Activity.class);

        if (view.getId() == viewIDS.get(0)) {
            whiteBoard.putExtra("OPTION", 0);
        }
        else if (view.getId() == viewIDS.get(1)) {
            whiteBoard.putExtra("OPTION", 1);
        }
        else if (view.getId() == viewIDS.get(2)) {
            whiteBoard.putExtra("OPTION", 2);
        }
        else if (view.getId() == viewIDS.get(3)) {
            whiteBoard.putExtra("OPTION", 3);
        }
        else if (view.getId() == viewIDS.get(4)) {
            whiteBoard.putExtra("OPTION", 4);
        }
        else if (view.getId() == viewIDS.get(5)) {
            whiteBoard.putExtra("OPTION", 5);
        }
        else if (view.getId() == viewIDS.get(6)) {
            whiteBoard.putExtra("OPTION", 6);
        }

        startActivity(whiteBoard);
        overridePendingTransition(R.anim.fade_in_activity, R.anim.fade_out_activity);
    }

    @Nullable
    private TextView getTitleTextView(Toolbar toolbar) {
        for (int x = 0; x < toolbar.getChildCount(); x++) {
            View child = toolbar.getChildAt(x);
            if (child instanceof  TextView) {
                return (TextView) child;
            }
        }
        return null;
    }

}
