package udacity.pawan.popularmoviesstage1.model.callback;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import udacity.pawan.popularmoviesstage1.model.PopularMovies;

/**
 * Created by pa1pal on 29/4/16.
 */
public interface MovieService {
    @GET("movie/{categories}?api_key=" + "paste Tmdb api here")
    Call<PopularMovies> getAllMovies(@Path("categories") String categories, @Query("page") int page_no );
}
