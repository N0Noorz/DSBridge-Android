package wendu.jsbdemo;

import android.os.Bundle;
import android.webkit.JavascriptInterface;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import wendu.dsbridge.CompletionHandler;
import wendu.dsbridge.DWebView;
import wendu.jsbdemo.databinding.ActivityWrokWithFlyioTestBinding;

public class WrokWithFlyioTestActivity extends AppCompatActivity {
    private ActivityWrokWithFlyioTestBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWrokWithFlyioTestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DWebView dWebView= binding.webview;
        dWebView.addJavascriptObject(new Object(){

            /**
             * Note: This method is for Fly.js
             * In browser, Ajax requests are sent by browser, but Fly can
             * redirect requests to native, more about Fly see  https://github.com/wendux/fly
             * @param requestData passed by fly.js, more detail reference https://wendux.github.io/dist/#/doc/flyio-en/native
             * @param handler
             */
            @JavascriptInterface
            public void onAjaxRequest(Object requestData, CompletionHandler handler){
                // Handle ajax request redirected by Fly
                AjaxHandler.onAjaxRequest((JSONObject)requestData,handler);
            }

        },null);

        dWebView.loadUrl("file:///android_asset/fly.html");
    }
}
