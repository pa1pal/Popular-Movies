package udacity.pawan.popularmoviesstage1.model.callback;

import retrofit2.Call;
import retrofit2.http.GET;
import udacity.pawan.popularmoviesstage1.model.PopularMovies;

/**
 * Created by pa1pal on 29/4/16.
 */
public interface MovieService {
    //    @GET("movie/{categories}?api_key=" + "api_key")
//    Call<PopularMovies> getAllMovies(@Path("categories") String categories, @Query("page") int page_no );
    @GET("movie/popular?api_key=" + "e22ade197291c2b6c56392801d8cd0a3")
    Call<PopularMovies> getAllMovies();
}
