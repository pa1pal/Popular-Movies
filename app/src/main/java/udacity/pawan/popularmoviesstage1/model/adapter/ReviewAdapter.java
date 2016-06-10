package udacity.pawan.popularmoviesstage1.model.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import udacity.pawan.popularmoviesstage1.R;
import udacity.pawan.popularmoviesstage1.model.ReviewResults;
import udacity.pawan.popularmoviesstage1.model.Reviews;
import udacity.pawan.popularmoviesstage1.model.VideoResults;


public class ReviewAdapter extends ArrayAdapter<Reviews> {

    private List<ReviewResults> mReviewResult;

    public static class ViewHolder {
        public final TextView contentView;
        public final TextView authorView;

        public ViewHolder(View view) {
            authorView = (TextView) view.findViewById(R.id.review_author);
            contentView = (TextView) view.findViewById(R.id.review_content);
        }
    }
    /**
     * This is a custom constructor.
     * The context is used to inflate the layout file, and reviews is the list of Trailers we want
     * to populate into the ListView.
     *
     * @param context The current context. Used to inflate the layout file.
     */
    public ReviewAdapter(Activity context) {
        super(context, 0);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The AdapterView position that is requesting a view
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        Reviews review = getItem(position);
        // Gets the Review object from the ArrayAdapter at the appropriate position
        //Reviews review =  getItem(position);

        // Adapters recycle views to AdapterViews.
        // If this is a new View object we're getting, then inflate the layout.
        // If not, this view already has the layout inflated from a previous call to getView,
        // and we modify the View widgets as usual.
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.review_list_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();
        if ( mReviewResult.get(position).getContent() != null) {
            viewHolder.contentView.setText(mReviewResult.get(position).getContent());
        }
        if (mReviewResult.get(position).getAuthor() != null) {
            viewHolder.authorView.setText(mReviewResult.get(position).getAuthor());
        }

        return convertView;
    }

}
