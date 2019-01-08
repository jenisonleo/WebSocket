package example.websocket.com.websocket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.ws.RealWebSocket;
import okio.ByteString;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editor=findViewById(R.id.editor);
        final TextView textView=findViewById(R.id.display);
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("ws://172.24.112.67:8080/message")
                .build();
        final WebSocket webSocket = client.newWebSocket(request, new WebSocketListener() {
            @Override
            public void onOpen(WebSocket webSocket, Response response) {
                Log.e("on open", " ");
            }

            @Override
            public void onMessage(WebSocket webSocket, String text) {
                Log.e("on onMessage", " ");
                textView.setText(text);
            }

            @Override
            public void onMessage(WebSocket webSocket, ByteString bytes) {
                Log.e("on onMessage hytes", " ");
            }

            @Override
            public void onClosing(WebSocket webSocket, int code, String reason) {
                Log.e("on onClosing", " ");
            }

            @Override
            public void onClosed(WebSocket webSocket, int code, String reason) {
                Log.e("on onClosed", " ");
            }

            @Override
            public void onFailure(WebSocket webSocket, Throwable t, Response response) {
                Log.e("on onFailure", " ");
            }
        });
        editor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                webSocket.send(""+s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}
