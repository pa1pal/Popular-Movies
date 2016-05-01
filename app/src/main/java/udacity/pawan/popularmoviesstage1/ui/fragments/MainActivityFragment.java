package udacity.pawan.popularmoviesstage1.ui.fragments;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import udacity.pawan.popularmoviesstage1.controller.ApiManager;
import udacity.pawan.popularmoviesstage1.model.PopularMovies;
import udacity.pawan.popularmoviesstage1.ui.MovieDetails;
import udacity.pawan.popularmoviesstage1.R;
import udacity.pawan.popularmoviesstage1.model.helper.RecyclerItemClickListner;
import udacity.pawan.popularmoviesstage1.model.adapter.GridAdapter;

public class MainActivityFragment extends Fragment implements RecyclerItemClickListner.OnItemClickListener {
    public static final int TYPE_LINEAR_LAYOUT = 1;
    public static final int TYPE_GRID_LAYOUT = 2;
    public static final int TYPE_STAGGERED_GRID_LAYOUT = 3;
    private  GridAdapter gridAdapter;
    private ApiManager apiManager;
    @Bind(R.id.rv)
    RecyclerView mRecyclerView;

    private int type = TYPE_LINEAR_LAYOUT;

    public static MainActivityFragment newInstance(int type) {
        MainActivityFragment fragment = new MainActivityFragment();
        Bundle args = new Bundle();
        args.putInt("type", type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            type = getArguments().getInt("type", TYPE_LINEAR_LAYOUT);
        }

        apiManager =  new ApiManager();
        Call<List<PopularMovies>> listCall = apiManager.getMovieService().getAllMovies();
        listCall.enqueue(new Callback<List<PopularMovies>>() {
            @Override
            public void onResponse(Call<List<PopularMovies>> call, Response<List<PopularMovies>> response) {
                if (response.isSuccessful()) {
                    List<PopularMovies> popularMoviesList = response.body();
                    for (int i=0; i<popularMoviesList.size(); i++)
                    {
                        PopularMovies popularMovies  = popularMoviesList.get(i);
                        gridAdapter.addMovies(popularMovies);
                    }
                }else{
                    int sc = response.code();
                    switch (sc){
                        case 400:
                            Log.e("Error 400", "Bad Request");
                            break;
                        case 404:
                            Log.e("Error 404", "Not Found");
                            break;
                        default:
                            Log.e("Error", "Generic Error");
                    }
                }
            }

            @Override
            public void onFailure(Call<List<PopularMovies>> call, Throwable t) {

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListner(getActivity(), this));
        gridAdapter = new GridAdapter(getActivity());

        mRecyclerView.setAdapter(gridAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public static Fragment newInstance() {
        return  new MainActivityFragment();
    }


    @Override
    public void onItemClick(View childView, int position) {
        Intent intent = new Intent(getActivity(), MovieDetails.class);
        startActivity(intent);
    }

    @Override
    public void onItemLongPress(View childView, int position) {

    }
}
