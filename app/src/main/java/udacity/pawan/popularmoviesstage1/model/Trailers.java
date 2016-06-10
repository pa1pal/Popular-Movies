package udacity.pawan.popularmoviesstage1.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pa1pal on 6/10/16.
 */
public class Trailers  {


        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("results")
        @Expose
        private List<VideoResults> results = new ArrayList<VideoResults>();

        /**
         *
         * @return
         * The id
         */
        public String getId() {
            return id;
        }

        /**
         *
         * @param id
         * The id
         */
        public void setId(String id) {
            this.id = id;
        }

        /**
         *
         * @return
         * The results
         */
        public List<VideoResults> getVideoResults() {
            return results;
        }

        /**
         *
         * @param results
         * The results
         */
        public void setResults(List<VideoResults> results) {
            this.results = results;
        }

}
