package udacity.pawan.popularmoviesstage1.model.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import udacity.pawan.popularmoviesstage1.R;
import udacity.pawan.popularmoviesstage1.model.ReviewResults;
import udacity.pawan.popularmoviesstage1.model.Reviews;


public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder>{

    private List<ReviewResults> mReviewResult;
    private Context mContext;

    public ReviewAdapter(Activity context, List<ReviewResults> results) {
        mContext = context;
        mReviewResult = results;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_list_item, null, false);
        //return new ImageViewHolder(mLayoutInflater.inflate(R.layout.recyclerview_item, parent, false));
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (mReviewResult.get(position).getContent() != null) {
            holder.contentView.setText(mReviewResult.get(position).getContent());
        }
        else
        holder.contentView.setText("Reviews not available");


        if (mReviewResult.get(position).getAuthor() != null) {
            holder.authorView.setText(mReviewResult.get(position).getAuthor());
        }
    }

    @Override
    public int getItemCount() {
        return mReviewResult.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        @Bind(R.id.review_author) TextView authorView;
        @Bind(R.id.review_content) TextView contentView;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
