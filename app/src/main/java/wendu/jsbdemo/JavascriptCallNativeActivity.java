package wendu.jsbdemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import wendu.dsbridge.DWebView;
import wendu.jsbdemo.databinding.ActivityJsCallNativeBinding;

public class JavascriptCallNativeActivity extends AppCompatActivity {
    private ActivityJsCallNativeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityJsCallNativeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        final DWebView dwebView= binding.webview;
        // set debug mode
        DWebView.setWebContentsDebuggingEnabled(true);
        dwebView.addJavascriptObject(new JsApi(), null);
        dwebView.addJavascriptObject(new JsEchoApi(),"echo");
        dwebView.loadUrl("file:///android_asset/js-call-native.html");
    }
}
