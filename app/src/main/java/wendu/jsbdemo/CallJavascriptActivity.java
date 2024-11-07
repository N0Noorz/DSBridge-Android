package wendu.jsbdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import wendu.dsbridge.DWebView;
import wendu.dsbridge.OnReturnValue;
import wendu.jsbdemo.databinding.ActivityCallJavascriptBinding;

public class CallJavascriptActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityCallJavascriptBinding binding;

    DWebView dWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCallJavascriptBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.addValue.setOnClickListener(this);
        binding.append.setOnClickListener(this);
        binding.startTimer.setOnClickListener(this);
        binding.synAddValue.setOnClickListener(this);
        binding.synGetInfo.setOnClickListener(this);
        binding.asynAddValue.setOnClickListener(this);
        binding.asynGetInfo.setOnClickListener(this);
        binding.hasMethodAddValue.setOnClickListener(this);
        binding.hasMethodXX.setOnClickListener(this);
        binding.hasMethodAsynAddValue.setOnClickListener(this);
        binding.hasMethodAsynXX.setOnClickListener(this);
        DWebView.setWebContentsDebuggingEnabled(true);
        dWebView = binding.webview;
        dWebView.loadUrl("file:///android_asset/native-call-js.html");


    }


    void showToast(Object o) {
        Toast.makeText(this, o.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addValue:
                dWebView.callHandler("addValue", new Object[]{3, 4}, new OnReturnValue<Integer>() {
                    @Override
                    public void onValue(Integer retValue) {
                        showToast(retValue);
                    }
                });
                break;
            case R.id.append:
                dWebView.callHandler("append", new Object[]{"I", "love", "you"}, new OnReturnValue<String>() {
                    @Override
                    public void onValue(String retValue) {
                        showToast(retValue);
                    }
                });
                break;
            case R.id.startTimer:
                dWebView.callHandler("startTimer", new OnReturnValue<Integer>() {
                    @Override
                    public void onValue(Integer retValue) {
                        showToast(retValue);
                    }
                });
                break;
            case R.id.synAddValue:
                dWebView.callHandler("syn.addValue", new Object[]{5, 6}, new OnReturnValue<Integer>() {
                    @Override
                    public void onValue(Integer retValue) {
                        showToast(retValue);
                    }
                });
                break;
            case R.id.synGetInfo:
                dWebView.callHandler("syn.getInfo", new OnReturnValue<JSONObject>() {
                    @Override
                    public void onValue(JSONObject retValue) {
                        showToast(retValue);
                    }
                });
                break;
            case R.id.asynAddValue:
                dWebView.callHandler("asyn.addValue", new Object[]{5, 6}, new OnReturnValue<Integer>() {
                    @Override
                    public void onValue(Integer retValue) {
                        showToast(retValue);
                    }
                });
                break;
            case R.id.asynGetInfo:
                dWebView.callHandler("asyn.getInfo", new OnReturnValue<JSONObject>() {
                    @Override
                    public void onValue(JSONObject retValue) {
                        showToast(retValue);
                    }
                });
                break;
            case R.id.hasMethodAddValue:
                dWebView.hasJavascriptMethod("addValue", new OnReturnValue<Boolean>() {
                    @Override
                    public void onValue(Boolean retValue) {
                        showToast(retValue);
                    }
                });
                break;
            case R.id.hasMethodXX:
                dWebView.hasJavascriptMethod("XX", new OnReturnValue<Boolean>() {
                    @Override
                    public void onValue(Boolean retValue) {
                        showToast(retValue);
                    }
                });
                break;
            case R.id.hasMethodAsynAddValue:
                dWebView.hasJavascriptMethod("asyn.addValue", new OnReturnValue<Boolean>() {
                    @Override
                    public void onValue(Boolean retValue) {
                        showToast(retValue);
                    }
                });
                break;
            case R.id.hasMethodAsynXX:
                dWebView.hasJavascriptMethod("asyn.XX", new OnReturnValue<Boolean>() {
                    @Override
                    public void onValue(Boolean retValue) {
                        showToast(retValue);
                    }
                });
                break;
        }

    }
}
