package sk.denis.davidek.androidjokedisplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {

    private TextView jokeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        jokeTextView = (TextView) findViewById(R.id.tv_joke);
        String joke = getIntent().getStringExtra(getString(R.string.key_joke));
        jokeTextView.setText(joke);
    }
}
