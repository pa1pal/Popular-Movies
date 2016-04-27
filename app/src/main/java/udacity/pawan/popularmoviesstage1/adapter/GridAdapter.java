package udacity.pawan.popularmoviesstage1.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import udacity.pawan.popularmoviesstage1.R;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ImageViewHolder> {
    private final LayoutInflater mLayoutInflater;
    private Context mContext;
    private String[] mTitles;

    public GridAdapter(Context context) {
        mTitles = context.getResources().getStringArray(R.array.urls);
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public interface mClickListener {
        public void mClick(View v, int position);
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageViewHolder(mLayoutInflater.inflate(R.layout.recyclerview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.movie_poster)
        ImageView imageView;

        ImageViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @OnClick(R.id.cv)
        void onItemClick() {
            Log.d("NormalTextViewHolder", "onClick--> position = " + getPosition());
           // Intent details = new Intent();
        }
    }
}
