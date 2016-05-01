package udacity.pawan.popularmoviesstage1.model.helper;

/**
 * Created by pa1pal on 29/4/16.
 */
public class Constants {
    public static final class HTTP {
        public static final String BASE_URL = "http://api.themoviedb.org/3/";
        private static final String IMAGE_POSTER_BASE_URL = "http://image.tmdb.org/t/p/w500";
    }

    public static final class REFERENCE {
        public static final String MOVIE = Config.PACKAGE_NAME + "movie";
    }

    public static final class Config {
        public static final String PACKAGE_NAME = "udacity.pawan.popularmoviesstage1.";
    }
}
