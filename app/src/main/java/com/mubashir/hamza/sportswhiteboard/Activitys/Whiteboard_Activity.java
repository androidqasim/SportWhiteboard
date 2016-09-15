package com.mubashir.hamza.sportswhiteboard.Activitys;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mubashir.hamza.sportswhiteboard.R;
import com.mubashir.hamza.sportswhiteboard.Services.ServicesImpl.DrawingBoard;
import com.mubashir.hamza.sportswhiteboard.Services.ServicesImpl.MenuCategoriesServiceImpl;

public class Whiteboard_Activity extends AppCompatActivity {

    private int OPTION;
    private int MENUOPTIONID;
    private int previousOption = 0;
    private LinearLayout fragmentBackground = null;
    private Button blueButton = null;
    private Button redButton = null;
    private Button yellowButton = null;
    private Button eraseButton = null;
    private Button clearButton = null;
    private int blueColor;
    private int redColor;
    private int yellowColor;
    private int eraseColor;

    private DrawingBoard drawingBoard = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whiteboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarMenu);
        setSupportActionBar(toolbar);

        OPTION = getIntent().getIntExtra("OPTION", 0);

        fragmentBackground = (LinearLayout) findViewById(R.id.drawingSection);

        final Typeface font_one = Typeface.createFromAsset(getAssets(), "font_one.otf");

        blueButton = (Button) findViewById(R.id.blueButton);
        redButton = (Button) findViewById(R.id.redButton);
        yellowButton = (Button) findViewById(R.id.yellowButton);
        eraseButton = (Button) findViewById(R.id.eraseButton);
        clearButton = (Button) findViewById(R.id.clearButton);
        clearButton.setTypeface(font_one);

        previousOption = R.id.blueButton;

        TextView titleBarText = (TextView) getTitleTextView(toolbar);
        final Typeface font_three = Typeface.createFromAsset(getAssets(), "font_three.ttf");
        titleBarText.setTypeface(font_three);
        titleBarText.setTextSize(TypedValue.COMPLEX_UNIT_SP, (getResources().getDimension(R.dimen.title)*1.5f));
        titleBarText.setTextColor(ContextCompat.getColor(this, R.color.title_menu));

        blueColor = ContextCompat.getColor(this, R.color.blue);
        redColor = ContextCompat.getColor(this, R.color.red);
        yellowColor = ContextCompat.getColor(this, R.color.yellow);
        eraseColor = ContextCompat.getColor(this, R.color.white);

        LinearLayout drawingBoardLayout = (LinearLayout) findViewById(R.id.drawingSection);
        drawingBoard = new DrawingBoard(this, blueColor);
        drawingBoardLayout.addView(drawingBoard);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        if (OPTION == 0) {
            menu.add(Menu.NONE, new MenuCategoriesServiceImpl().getMenuFullBasketball(), 0, "Full Court");
            menu.add(Menu.NONE, new MenuCategoriesServiceImpl().getMenuHalfBasketball(), 1, "Half Court");
            fragmentBackground.setBackgroundResource(getResources().getIdentifier("basketball_full_court", "drawable", getPackageName()));
        }
        else if (OPTION == 1) {
            menu.add(Menu.NONE, new MenuCategoriesServiceImpl().getMenuFullBaseball(), 0, "Full Field");
            menu.add(Menu.NONE, new MenuCategoriesServiceImpl().getMenuHalfBaseball(), 1, "Only Diamond");
            fragmentBackground.setBackgroundResource(getResources().getIdentifier("baseball_full_field", "drawable", getPackageName()));
        }
        else if (OPTION == 2) {
            menu.add(Menu.NONE, new MenuCategoriesServiceImpl().getMenuFullFootball(), 0, "Full Field");
            menu.add(Menu.NONE, new MenuCategoriesServiceImpl().getMenuHalfFootball(), 1, "Half Field");
            fragmentBackground.setBackgroundResource(getResources().getIdentifier("football_full_field", "drawable", getPackageName()));
        }
        else if (OPTION == 3) {
            menu.add(Menu.NONE, new MenuCategoriesServiceImpl().getMenuFullHockey(), 0, "Full Rink");
            menu.add(Menu.NONE, new MenuCategoriesServiceImpl().getMenuHalfHockey(), 1, "Half Rink");
            fragmentBackground.setBackgroundResource(getResources().getIdentifier("hockey_full_rink", "drawable", getPackageName()));
        }
        else if (OPTION == 4) {
            menu.add(Menu.NONE, new MenuCategoriesServiceImpl().getMenuFullSoccer(), 0, "Full Field");
            menu.add(Menu.NONE, new MenuCategoriesServiceImpl().getMenuHalfSoccer(), 1, "Half Field");
            fragmentBackground.setBackgroundResource(getResources().getIdentifier("soccer_full_field", "drawable", getPackageName()));
        }
        else if (OPTION == 5) {
            menu.add(Menu.NONE, new MenuCategoriesServiceImpl().getMenuFullVolleyball(), 0, "Full Court");
            menu.add(Menu.NONE, new MenuCategoriesServiceImpl().getMenuHalfVolleyball(), 1, "Half Court");
            fragmentBackground.setBackgroundResource(getResources().getIdentifier("volleyball_full_court", "drawable", getPackageName()));
        }
        else if (OPTION == 6) {
            menu.add(Menu.NONE, new MenuCategoriesServiceImpl().getMenuFullTennis(), 0, "Full Court");
            menu.add(Menu.NONE, new MenuCategoriesServiceImpl().getMenuHalfTennis(), 1, "Half Court");
            fragmentBackground.setBackgroundResource(getResources().getIdentifier("tennis_full_court", "drawable", getPackageName()));
        }

        MENUOPTIONID = menu.getItem(0).getItemId();

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() != MENUOPTIONID) {
            // Change backgrounds here
            if (item.getItemId() == new MenuCategoriesServiceImpl().getMenuFullBasketball()) {
                fragmentBackground.setBackgroundResource(getResources().getIdentifier("basketball_full_court", "drawable", getPackageName()));
                drawingBoard.setResetWindow();
            }
            else if (item.getItemId() == new MenuCategoriesServiceImpl().getMenuHalfBasketball()) {
                fragmentBackground.setBackgroundResource(getResources().getIdentifier("basketball_half_court", "drawable", getPackageName()));
                drawingBoard.setResetWindow();
            }
            else if (item.getItemId() == new MenuCategoriesServiceImpl().getMenuFullBaseball()) {
                fragmentBackground.setBackgroundResource(getResources().getIdentifier("baseball_full_field", "drawable", getPackageName()));
                drawingBoard.setResetWindow();
            }
            else if (item.getItemId() == new MenuCategoriesServiceImpl().getMenuHalfBaseball()) {
                fragmentBackground.setBackgroundResource(getResources().getIdentifier("baseball_half_field", "drawable", getPackageName()));
                drawingBoard.setResetWindow();
            }
            else if (item.getItemId() == new MenuCategoriesServiceImpl().getMenuFullFootball()) {
                fragmentBackground.setBackgroundResource(getResources().getIdentifier("football_full_field", "drawable", getPackageName()));
                drawingBoard.setResetWindow();
            }
            else if (item.getItemId() == new MenuCategoriesServiceImpl().getMenuHalfFootball()) {
                fragmentBackground.setBackgroundResource(getResources().getIdentifier("football_half_field", "drawable", getPackageName()));
                drawingBoard.setResetWindow();
            }
            else if (item.getItemId() == new MenuCategoriesServiceImpl().getMenuFullHockey()) {
                fragmentBackground.setBackgroundResource(getResources().getIdentifier("hockey_full_rink", "drawable", getPackageName()));
                drawingBoard.setResetWindow();
            }
            else if (item.getItemId() == new MenuCategoriesServiceImpl().getMenuHalfHockey()) {
                fragmentBackground.setBackgroundResource(getResources().getIdentifier("hockey_half_rink", "drawable", getPackageName()));
                drawingBoard.setResetWindow();
            }
            else if (item.getItemId()== new MenuCategoriesServiceImpl().getMenuFullSoccer()) {
                fragmentBackground.setBackgroundResource(getResources().getIdentifier("soccer_full_field", "drawable", getPackageName()));
                drawingBoard.setResetWindow();
            }
            else if (item.getItemId() == new MenuCategoriesServiceImpl().getMenuHalfSoccer()) {
                fragmentBackground.setBackgroundResource(getResources().getIdentifier("soccer_half_field", "drawable", getPackageName()));
                drawingBoard.setResetWindow();
            }
            else if (item.getItemId() == new MenuCategoriesServiceImpl().getMenuFullVolleyball()) {
                fragmentBackground.setBackgroundResource(getResources().getIdentifier("volleyball_full_court", "drawable", getPackageName()));
                drawingBoard.setResetWindow();
            }
            else if (item.getItemId() == new MenuCategoriesServiceImpl().getMenuHalfVolleyball()) {
                fragmentBackground.setBackgroundResource(getResources().getIdentifier("volleyball_half_court", "drawable", getPackageName()));
                drawingBoard.setResetWindow();
            }
            else if (item.getItemId() == new MenuCategoriesServiceImpl().getMenuFullTennis()) {
                fragmentBackground.setBackgroundResource(getResources().getIdentifier("tennis_full_court", "drawable", getPackageName()));
                drawingBoard.setResetWindow();
            }
            else if (item.getItemId() == new MenuCategoriesServiceImpl().getMenuHalfTennis()) {
                fragmentBackground.setBackgroundResource(getResources().getIdentifier("tennis_half_court", "drawable", getPackageName()));
                drawingBoard.setResetWindow();
            }

            MENUOPTIONID = item.getItemId();
        }

        return super.onOptionsItemSelected(item);
    }

    public void onButtonOptionsClick(View view) {
        switch(view.getId()) {
            case R.id.blueButton :
                if (previousOption != view.getId()) {
                    resetButtons(previousOption);
                    previousOption = R.id.blueButton;
                    blueButton.setBackgroundResource(getResources().getIdentifier("blue_selected", "drawable", getPackageName()));
                    drawingBoard.setEraseColor(false);
                    drawingBoard.setPaintColor(blueColor);
                    break;
                }
                break;
            case R.id.redButton :
                if (previousOption != view.getId()) {
                    resetButtons(previousOption);
                    previousOption = R.id.redButton;
                    redButton.setBackgroundResource(getResources().getIdentifier("red_selected", "drawable", getPackageName()));
                    drawingBoard.setEraseColor(false);
                    drawingBoard.setPaintColor(redColor);
                    break;
                }
                break;
            case R.id.yellowButton :
                if (previousOption != view.getId()) {
                    resetButtons(previousOption);
                    previousOption = R.id.yellowButton;
                    yellowButton.setBackgroundResource(getResources().getIdentifier("yellow_selected", "drawable", getPackageName()));
                    drawingBoard.setEraseColor(false);
                    drawingBoard.setPaintColor(yellowColor);
                    break;
                }
                break;
            case R.id.eraseButton :
                if (previousOption != view.getId()) {
                    resetButtons(previousOption);
                    previousOption = R.id.eraseButton;
                    eraseButton.setBackgroundResource(getResources().getIdentifier("white_selected", "drawable", getPackageName()));
                    drawingBoard.setEraseColor(true);
                    drawingBoard.setPaintColor(Color.TRANSPARENT);
                    break;
                }
                break;
            case R.id.clearButton :
                // clear the board and also clear once the menu is called
                drawingBoard.setResetWindow();
                break;
        }
    }

    private void resetButtons(int ID) {
        switch(ID) {
            case R.id.blueButton :
                blueButton.setBackgroundResource(getResources().getIdentifier("blue_not_selected", "drawable", getPackageName()));
                break;
            case R.id.redButton :
                redButton.setBackgroundResource(getResources().getIdentifier("red_not_selected", "drawable", getPackageName()));
                break;
            case R.id.yellowButton :
                yellowButton.setBackgroundResource(getResources().getIdentifier("yellow_not_selected", "drawable", getPackageName()));
                break;
            case R.id.eraseButton :
                eraseButton.setBackgroundResource(getResources().getIdentifier("white_not_selected", "drawable", getPackageName()));
                break;
        }
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

