package udacity.pawan.popularmoviesstage1.model.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import udacity.pawan.popularmoviesstage1.R;
import udacity.pawan.popularmoviesstage1.model.pojos.Result;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ImageViewHolder> {

    private Context mContext;
    private String[] mTitles;
    private List<Result> mResult;

    public GridAdapter(Context context , @Nullable List<Result> results) {
        // mTitles = context.getResources().getStringArray(R.array.urls);
        mContext = context;
        // mLayoutInflater = LayoutInflater.from(context);
        mResult = results;
    }


    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, null, false);
        //return new ImageViewHolder(mLayoutInflater.inflate(R.layout.recyclerview_item, parent, false));
        return new ImageViewHolder(row);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {

        Picasso.with(holder.itemView.getContext())
                .load("http://image.tmdb.org/t/p/w500" + mResult.get(position).getPosterPath())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mResult.size();
    }


    public class ImageViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.movie_poster)
        ImageView imageView;

        ImageViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
