package udacity.pawan.popularmoviesstage1.controller;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import udacity.pawan.popularmoviesstage1.model.callback.MovieService;

/**
 * Created by pa1pal on 30/4/16.
 */
public class ApiManager {
    private MovieService movieService;

    public MovieService getMovieService(){
        if (movieService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://api.themoviedb.org/3/")
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
