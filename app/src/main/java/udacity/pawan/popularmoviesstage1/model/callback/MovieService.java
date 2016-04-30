package udacity.pawan.popularmoviesstage1.model.callback;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import udacity.pawan.popularmoviesstage1.model.PopularMovies;

/**
 * Created by pa1pal on 29/4/16.
 */
public interface MovieService {
    @GET("movie/popular")
    Call<List<PopularMovies>> getAllMovies();
}
