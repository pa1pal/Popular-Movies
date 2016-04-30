package udacity.pawan.popularmoviesstage1.controller;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import udacity.pawan.popularmoviesstage1.model.callback.MovieService;
import udacity.pawan.popularmoviesstage1.model.helper.Constants;

/**
 * Created by pa1pal on 30/4/16.
 */
public class ApiManager {
    private MovieService movieService;

    public MovieService getMovieService(){
        if (movieService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.HTTP.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            movieService = retrofit.create(MovieService.class);
        }
        return movieService;
    }

//    public void getAllMovies( Callback<PopularMovies> callback){
//        Call<PopularMovies> moviecall = movieService.getAllMovies();
//        moviecall.enqueue(callback);
//    }

}
