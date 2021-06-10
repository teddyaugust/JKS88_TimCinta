package com.jks88.timcinta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.AdRequest;

import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class  ContactActivity extends AppCompatActivity {

    //Memanggil Variabel Widget Drawer supaya bisa dicoding
    //Inisialiasi Variabel
    DrawerLayout drawerLayout;
    private AdView mAdView;
    WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        //buka webnya
        webView = findViewById(R.id.kontak_webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://bisnis.flazhincinta.id/kontak-tim-cinta/");

        WebSettings webSettings = webView.getSettings();

        webSettings.setJavaScriptEnabled(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.supportZoom();
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);

        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);

        webView.setWebChromeClient(new WebChromeClient());

        webView.setWebViewClient(new WebViewClient()
        {
            @Override
            public boolean shouldOverrideUrlLoading(WebView wv, String url) {
                if(url.startsWith("tel:") || url.startsWith("whatsapp:") || url.startsWith("tg:") || url.startsWith("facebook:") ) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                    return true;
                }
                return false;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        });

        //loading ads google
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView_kontak);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

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
        ///Recreate activity
        recreate();
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
        //Redirect activity ke Testimoni Produk
        MainActivity.redirectActivity(this,TestimonyActivity.class);
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