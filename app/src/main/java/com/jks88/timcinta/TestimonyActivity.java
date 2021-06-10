package com.jks88.timcinta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;



public class  TestimonyActivity extends AppCompatActivity {

    //Memanggil Variabel Widget Drawer supaya bisa dicoding
    //Inisialiasi Variabel
    DrawerLayout drawerLayout;
    WebView webView;
    private AdView mAdView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testimony);

        //loading ads google
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView_testimoni);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //buka webnya
        webView = (WebView) findViewById(R.id.testimoni_webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://bisnis.flazhincinta.id/testimoni/");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //assign variabelnya
        drawerLayout = findViewById(R.id.drawer_layout);

    }

    public void ClickMenu(View view){
        //Open drawer
        MainActivity.openDrawer (drawerLayout);
    }

    public void ClickLogo(View view){
        //Close Drawernya
        MainActivity.closeDrawer(drawerLayout);
    }

    public void ClickHome(View view){
        //Redirect activity ke Beranda
        MainActivity.redirectActivity(this,MainActivity.class);
    }

    public void ClickLogin (View view){
        //Redirect activity ke Login
        MainActivity.redirectActivity(this,AccountLoginActivity.class);
    }

    public void ClickAgenda (View view){
        //Redirect activity ke Agenda Kegiatan Tim
        MainActivity.redirectActivity(this,AgendaActivity.class);
    }

    public void ClickCompany (View view){
        //Redirect activity ke Info Perusahaan
        MainActivity.redirectActivity(this,CompanyActivity.class);
    }

    public void ClickKontakTimCinta (View view){
        //Redirect activity ke Kontak Tim Cinta
        MainActivity.redirectActivity(this,ContactActivity.class);
    }

    public void ClickPlan (View view){
        //Redirect activity ke Marketing Plan
        MainActivity.redirectActivity(this,MarketingPlanActivity.class);
    }

    public void ClickProduk (View view){
        //Redirect activity ke Produk
        MainActivity.redirectActivity(this,ProductActivity.class);
    }

    public void ClickTestimoni (View view){
        //Recreate activity
        recreate();
    }

    public void ClickTimCinta (View view){
        //Redirect activity ke Tim Cinta
        MainActivity.redirectActivity(this,TimCintaActivity.class);
    }

    public void ClickTutorial (View view){
        //Redirect activity ke Tutorial
        MainActivity.redirectActivity(this,TutorialActivity.class);
    }

    public void ClickInfoTerkini (View view){
        //Redirect activity ke Info Terkini Blogs
        MainActivity.redirectActivity(this,UpdateNewsActivity.class);
    }

    public void ClickLogout (View view){
        //Menutup Aplikasi
        MainActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Close Drawer
        MainActivity.closeDrawer(drawerLayout);
    }

}