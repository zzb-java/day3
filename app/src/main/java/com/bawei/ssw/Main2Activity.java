package com.bawei.ssw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final WebView webView =findViewById(R.id.webview);
        webView.loadUrl("file:///android_asset/myhtml.html");
        Intent intent = getIntent();
        final String name = intent.getStringExtra("name");
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        Button button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("javascript:callJS('"+name+"')");

            }
        });
    }
}
