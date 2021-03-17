package bhakadekailas.mvpdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements LoginActivityContract.View {

    private static final String TAG = LoginActivity.class.getSimpleName();
    EditText ETemail, ETpassword;
    Button buttonLogin;
    LoginActivityContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: ");
        setContentView(R.layout.activity_main);

        presenter = new LoginActivityPresenter(this);

        ETemail = findViewById(R.id.email);
        ETpassword = findViewById(R.id.password);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(v -> {
            Log.e(TAG, "onClick: ");
            String email = ETemail.getText().toString();
            String password = ETpassword.getText().toString();

            if (email.isEmpty() || password.isEmpty()) {
                onError("Required");
            } else {
                presenter.doLogin(email, password);
            }
        });
    }

    @Override
    public void onSuccess(String message) {
        Log.e(TAG, "onSuccess: ");
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String message) {
        Log.e(TAG, "onError: ");
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}