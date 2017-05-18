package com.sirvar.robin;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class RobinActivity extends AppCompatActivity {

    private LoginFragment loginFragment;
    private SignupFragment signupFragment;

    private String loginTitle;
    private String signupTitle;
    private Drawable logoDrawable;
    private Bitmap logoBitmap;
    private Typeface typeface;

    private Theme theme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robin);

        // Don't show toolbar
        getSupportActionBar().hide();

        if (findViewById(R.id.fragment_container) != null) {
            startLoginFragment();

        }

        setDefaults();
    }

    /**
     * Override form login
     *
     * @param email    username or email address entered by user
     * @param password raw password
     */
    protected abstract void onLogin(String email, String password);

    /**
     * Override form login
     *
     * @param email    username or email address entered by user
     */
    protected abstract void onForgotPassword(String email);

    protected void startLoginFragment() {
        loginFragment = new LoginFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, loginFragment)
                .commit();
    }

    protected void startForgotPasswordFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, loginFragment)
                .commit();
    }

    protected void startSignupFragment() {
        signupFragment = new SignupFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, signupFragment)
                .commit();
    }

    /**
     * Set title for login fragment
     *
     * @param title login title
     */
    protected void setLoginTitle(String title) {
        loginTitle = title;
        loginFragment.setTitle(loginTitle);
    }

    /**
     * Set theme for activity
     *
     * @param theme Light or Dark theme
     */
    protected void setTheme(Theme theme) {
        this.theme = theme;
    }

    /**
     * Set drawable image for logo
     *
     * @param drawable drawable logo
     */
    protected void setImage(Drawable drawable) {
        logoDrawable = drawable;
        loginFragment.setImage(logoDrawable);
    }

    /**
     * Set bitmap image for logo
     *
     * @param bitmap bitmap logo
     */
    protected void setImage(Bitmap bitmap) {
        logoBitmap = bitmap;
        loginFragment.setImage(logoBitmap);
    }

    /**
     * Use custom font for all Views
     *
     * @param typeface custom typeface
     */
    protected void setFont(Typeface typeface) {
        this.typeface = typeface;
        loginFragment.setFont(typeface);
    }

    protected void configureLogin() {
        if (logoDrawable != null) {
            loginFragment.setImage(logoDrawable);
        } else if (logoBitmap != null) {
            loginFragment.setImage(logoBitmap);
        }
    }

    /**
     * Set default values
     */
    private void setDefaults() {
        theme = Theme.LIGHT;
    }
}