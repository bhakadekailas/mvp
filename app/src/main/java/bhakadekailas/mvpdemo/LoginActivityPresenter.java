package bhakadekailas.mvpdemo;

import android.util.Log;

class LoginActivityPresenter implements LoginActivityContract.Presenter {
    private static final String TAG = LoginActivityPresenter.class.getSimpleName();

    LoginActivityContract.View view;

    public LoginActivityPresenter(LoginActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void doLogin(String email, String password) {
        Log.e(TAG, "doLogin: ");
        if (email.equals("k") && password.equals("k")) {
            view.onSuccess("Success");
        } else {
            view.onError("Wrong email or password");
        }
    }
}
