package udacity.pawan.popularmoviesstage1.model.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

import udacity.pawan.popularmoviesstage1.R;
import udacity.pawan.popularmoviesstage1.model.Trailers;
import udacity.pawan.popularmoviesstage1.model.VideoResults;


public class TrailerAdapter extends ArrayAdapter<Trailers> {


    private List<VideoResults> mVideoResult;
    private Context mContext;

    public static class ViewHolder {
        public final TextView trailerNameView;

        public ViewHolder(View view) {
            trailerNameView = (TextView) view.findViewById(R.id.trailer_name);
        }
    }


    public TrailerAdapter(Activity context, List<VideoResults> results) {
        super(context, 0);
        mContext = context;
        mVideoResult = results;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        // Gets the Trailer object from the ArrayAdapter at the appropriate position
        Trailers trailer = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.trailer_list_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }

        viewHolder = (ViewHolder) convertView.getTag();
        if (mVideoResult.get(position).getName() != null) {
            viewHolder.trailerNameView.setText(mVideoResult.get(position).getName());
            Log.v("Trailer Adapter", trailer.getVideoResults().get(position).getName());
        }

        return convertView;
    }
}
