package udacity.pawan.popularmoviesstage1.ui.fragments;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import udacity.pawan.popularmoviesstage1.R;
import udacity.pawan.popularmoviesstage1.controller.ApiManager;
import udacity.pawan.popularmoviesstage1.model.PopularMovies;
import udacity.pawan.popularmoviesstage1.model.adapter.GridAdapter;
import udacity.pawan.popularmoviesstage1.model.helper.RecyclerItemClickListner;
import udacity.pawan.popularmoviesstage1.ui.MovieDetails;

public class MainActivityFragment extends Fragment implements RecyclerItemClickListner.OnItemClickListener {
    public static final int TYPE_LINEAR_LAYOUT = 1;
    public static final int TYPE_GRID_LAYOUT = 2;
    public static final int TYPE_STAGGERED_GRID_LAYOUT = 3;
    public  final String LOG_TAG = getClass().getSimpleName();
    private  GridAdapter gridAdapter;
    private ApiManager apiManager;
    String category;
    @Bind(R.id.rv)
    RecyclerView mRecyclerView;

    private int type = TYPE_LINEAR_LAYOUT;
    private PopularMovies mPopularMovies;

    public static MainActivityFragment newInstance(int type) {
        MainActivityFragment fragment = new MainActivityFragment();
        Bundle args = new Bundle();
        args.putInt("type", type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onItemClick(View childView, int position) {
        Intent intent = new Intent(getActivity(), MovieDetails.class);
        intent.putExtra("MOVIE_DETAILS", (new Gson()).toJson(mPopularMovies.getResults().get(position)));
        startActivity(intent);
    }

    @Override
    public void onItemLongPress(View childView, int position) {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            type = getArguments().getInt("type", TYPE_LINEAR_LAYOUT);
        }
        mPopularMovies = new PopularMovies();



    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, rootView);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        category = sharedPreferences.getString(getString(R.string.category_key), getString(R.string.pref_default));

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListner(getActivity(), this));

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        loadPopuparMovies();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    public static Fragment newInstance() {
        return  new MainActivityFragment();
    }

    public void loadPopuparMovies(){
        apiManager =  new ApiManager();
        Call<PopularMovies> popularMoviesCall = apiManager.getMovieService().getAllMovies(category);
        popularMoviesCall.enqueue(new Callback<PopularMovies>() {
            @Override
            public void onResponse(Call<PopularMovies> call, Response<PopularMovies> response) {
                if(response.isSuccessful()){
                    mPopularMovies = response.body();
                    gridAdapter = new GridAdapter(getActivity(),mPopularMovies.getResults());
                    mRecyclerView.setAdapter(gridAdapter);
                    Log.d(LOG_TAG,mPopularMovies.getResults().get(2).getOriginalTitle());
                }
            }

            @Override
            public void onFailure(Call<PopularMovies> call, Throwable t) {

            }
        });
    }
}
