package udacity.pawan.popularmoviesstage1.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import udacity.pawan.popularmoviesstage1.R;
import udacity.pawan.popularmoviesstage1.model.Result;

/**
 * Created by pa1pal on 27/4/16.
 */
public class MovieDetailsFragment extends Fragment {
    private final String LOG_TAG = MovieDetailsFragment.class.getSimpleName();
    private Result mMovieDetails;

    @Bind(R.id.iv_image) ImageView mPosterImage;
    @Bind(R.id.tv_title) TextView mTitle;
    @Bind(R.id.plot) TextView mPlot;
    @Bind(R.id.rating) TextView mRating;
    @Bind(R.id.rdate) TextView mReleaseDate;

    public MovieDetailsFragment(Result result){
        mMovieDetails = result;
    }

    public MovieDetailsFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_movie_details, container, false);
        ButterKnife.bind(this, rootview);

        Picasso.with(getActivity())
                .load("http://image.tmdb.org/t/p/w500" + mMovieDetails.getPosterPath())
                .into(mPosterImage);

        mTitle.setText(mMovieDetails.getOriginalTitle());
        mPlot.setText("Overview \n" + mMovieDetails.getOverview());
        mRating.setText("User Rating : " + mMovieDetails.getVoteAverage());
        mReleaseDate.setText("Release Date : " + mMovieDetails.getReleaseDate());

        return  rootview;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
