package wendu.jsbdemo

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import wendu.dsbridge.DWebView
import wendu.jsbdemo.databinding.ActivityNewkiMainBinding

class NewkiMainActivity : AppCompatActivity() {
    private var _binding: ActivityNewkiMainBinding? = null
    private val binding get() = _binding!!
    lateinit var mainWebView: DWebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        _binding = ActivityNewkiMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        mainWebView = binding.webview
        val webViewClient = WebViewClient()
        val webChromeClient = WebChromeClient()

        mainWebView.webViewClient = webViewClient
        mainWebView.webChromeClient = webChromeClient
        mainWebView.addJavascriptObject(JsApi(), null)
        mainWebView.loadUrl("https://www.newki.com")
    }

}