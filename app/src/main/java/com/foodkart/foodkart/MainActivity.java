package com.foodkart.foodkart;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setTitle("Home");
                    FragmentHome fragment1 = new FragmentHome();
                    FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.frame, fragment1);
                    fragmentTransaction1.commit();
                    return true;
                case R.id.navigation_dashboard:
                    setTitle("Dashboard");
                    FragmentDashboard fragment2 = new FragmentDashboard();
                    FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.frame, fragment2);
                    fragmentTransaction2.commit();
                    return true;
                case R.id.navigation_notifications:
                    setTitle("Notifications");
                    FragmentNotifications fragment3 = new FragmentNotifications();
                    FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction3.replace(R.id.frame, fragment3);
                    fragmentTransaction3.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //changing statusbar color
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimary));
        }

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //Default Home page
        FragmentHome fragment1 = new FragmentHome();
        FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
        fragmentTransaction1.replace(R.id.frame, fragment1, "Home");
        fragmentTransaction1.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {

            Toast.makeText(this, "Hey you just hit" + item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void contentView() {
        setContentView(R.layout.content_view);

        WebView webView = (WebView) findViewById(R.id.content_view);

        //findViewById returns an instance of View ,which is casted to target class
        webView.setWebViewClient(new WebViewClient());

        webView.getSettings().setJavaScriptEnabled(true);
        //This statement is used to enable the execution of JavaScript.

        webView.setVerticalScrollBarEnabled(false);
        //This statement hides the Vertical scroll bar and does not remove it.

        webView.setHorizontalScrollBarEnabled(false);
        //This statement hides the Horizontal scroll bar and does not remove it.

    }


    public void onFpView() {
        contentView();
        WebView webView = (WebView) findViewById(R.id.content_view);
        webView.loadUrl("https://www.foodpanda.in/login");
    }

    public void onSwiggyView() {
        contentView();
        WebView webView = (WebView) findViewById(R.id.content_view);
        webView.loadUrl("https://www.swiggy.com/auth");
    }

    public void onZomatoView() {
        contentView();
        WebView webView = (WebView) findViewById(R.id.content_view);
        webView.loadUrl("https://www.zomato.com/login?redirect_url=");
    }

    public void onUberEatsView() {
        contentView();
        WebView webView = (WebView) findViewById(R.id.content_view);
        webView.loadUrl("https://auth.uber.com/login/?next_url=https://www.ubereats.com");
    }

    public void onFreshMenuView() {
        contentView();
        WebView webView = (WebView) findViewById(R.id.content_view);
        webView.loadUrl("https://www.freshmenu.com/signin");
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        WebView webView = (WebView) findViewById(R.id.content_view);
        //findViewById returns an instance of View ,which is casted to target class
        webView.setWebViewClient(new WebViewClient());

        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }


}
