package udacity.pawan.popularmoviesstage1.ui;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;

import udacity.pawan.popularmoviesstage1.R;
import udacity.pawan.popularmoviesstage1.model.pojos.Result;
import udacity.pawan.popularmoviesstage1.ui.fragments.MovieDetailsFragment;

public class MovieDetails extends AppCompatActivity {

    private final String LOG_TAG = MovieDetails.class.getSimpleName();

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details);

        final Intent intent = getIntent();
        Result result = (new Gson()).fromJson(intent.getStringExtra("MOVIE_DETAILS"), Result.class);
        int movieid = intent.getIntExtra("MOVIE_ID", 293660);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().add(R.id.container, new MovieDetailsFragment(result, movieid)).commit();
        }
    }
}
