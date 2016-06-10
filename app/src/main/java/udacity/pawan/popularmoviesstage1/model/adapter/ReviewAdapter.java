package udacity.pawan.popularmoviesstage1.model.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import udacity.pawan.popularmoviesstage1.R;
import udacity.pawan.popularmoviesstage1.model.ReviewResults;
import udacity.pawan.popularmoviesstage1.model.Reviews;


public class ReviewAdapter extends ArrayAdapter<Reviews> {

    private List<ReviewResults> mReviewResult;
    private Context mContext;

    public ReviewAdapter(Context context, List<ReviewResults> results) {

        super(context, 0);
        mContext = context;
        mReviewResult = results;
    }

    public static class ViewHolder {
        public final TextView contentView;
        public final TextView authorView;

        public ViewHolder(View view) {
            authorView = (TextView) view.findViewById(R.id.review_author);
            contentView = (TextView) view.findViewById(R.id.review_content);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        Reviews review = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.review_list_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();
        if (mReviewResult.get(position).getContent() != null) {
            viewHolder.contentView.setText(mReviewResult.get(position).getContent());
        }

        if (review.getReviewsResults().get(position).getAuthor() != null) {
            viewHolder.authorView.setText(review.getReviewsResults().get(position).getAuthor());
        }
        Log.v("Trailer Adapter", mReviewResult.get(position).getAuthor());

        return convertView;
    }

}
