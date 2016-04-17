package udacity.pawan.popularmoviesstage1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import udacity.pawan.popularmoviesstage1.adapter.GridAdapter;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    public static final int TYPE_LINEAR_LAYOUT = 1;
    private static final int SPAN_COUNT = 2;
    @Bind(R.id.rv) RecyclerView recyclerView;
    protected RecyclerView.LayoutManager layoutManager;
    private int type = TYPE_LINEAR_LAYOUT;

    List<Integer> resourceIds = Arrays.asList(R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher);

    public static MainActivityFragment newInstance(int type) {
        MainActivityFragment fragment= new MainActivityFragment();
        Bundle args = new Bundle();
        args.putInt("type", type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            type = getArguments().getInt("type", TYPE_LINEAR_LAYOUT);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, rootview);
//        layoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setHasFixedSize(true);

        //recyclerView.setAdapter(new GridAdapter(resourceIds));
        return rootview;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), SPAN_COUNT));
        recyclerView.setAdapter(new GridAdapter(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
