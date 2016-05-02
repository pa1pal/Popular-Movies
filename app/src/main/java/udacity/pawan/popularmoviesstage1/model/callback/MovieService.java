package udacity.pawan.popularmoviesstage1.model.callback;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import udacity.pawan.popularmoviesstage1.BuildConfig;
import udacity.pawan.popularmoviesstage1.model.PopularMovies;

/**
 * Created by pa1pal on 29/4/16.
 */
public interface MovieService {
    //    @GET("movie/{categories}?api_key=" + "api_key")
//    Call<PopularMovies> getAllMovies(@Path("categories") String categories, @Query("page") int page_no );
    @GET("movie/{category}?api_key=" + BuildConfig.MOVIE_API_KEY)
    Call<PopularMovies> getAllMovies(@Path("category") String category);
}
