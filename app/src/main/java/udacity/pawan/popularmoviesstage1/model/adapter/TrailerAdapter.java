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
import udacity.pawan.popularmoviesstage1.model.Trailers;
import udacity.pawan.popularmoviesstage1.model.VideoResults;


public class TrailerAdapter extends RecyclerView.Adapter<TrailerAdapter.ViewHolder> {


    private List<VideoResults> mVideoResult;
    private Context mContext;

    public TrailerAdapter(Activity context, List<VideoResults> results) {
        mContext = context;
        mVideoResult = results;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.trailer_list_item, null, false);
        //return new ImageViewHolder(mLayoutInflater.inflate(R.layout.recyclerview_item, parent, false));
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (mVideoResult.get(position).getName() != null) {
            holder.trailerNameView.setText(mVideoResult.get(position).getName());
        }
    }



    @Override
    public int getItemCount() {
        return mVideoResult.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.trailer_name) TextView trailerNameView;
        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
