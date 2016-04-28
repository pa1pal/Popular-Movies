package udacity.pawan.popularmoviesstage1.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import udacity.pawan.popularmoviesstage1.R;

/**
 * Created by pa1pal on 27/4/16.
 */
public class MovieDetailsFragment extends Fragment {
    private final String LOG_TAG = MovieDetailsFragment.class.getSimpleName();

    public MovieDetailsFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_movie_details, container, false);

        return  rootview;
    }
}
