package udacity.pawan.popularmoviesstage1.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by pa1pal on 30/4/16.
 */
public class PopularMovies {

    private int page;
    private List<Result> results;

    @SerializedName("total_results")
    private long totalResults;

    @SerializedName("total_pages")
    private int totalPages;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(long totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

}
