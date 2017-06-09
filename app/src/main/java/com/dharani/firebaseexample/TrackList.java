package com.dharani.firebaseexample;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by LENOVO on 06/09/17.
 */

public class TrackList extends ArrayAdapter{
    private Activity context;
    private List<Track> tracks;

    public TrackList(Activity context, List<Track> tracks) {
        super(context, R.layout.track_list_layout, tracks);
        this.context = context;
        this.tracks = tracks;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listView = inflater.inflate(R.layout.track_list_layout,null,true);

        TextView txtName = (TextView)listView.findViewById(R.id.textView_Name1);
        TextView txtRating = (TextView)listView.findViewById(R.id.textView_Rating);

        Track track = tracks.get(position);

        txtName.setText(track.getTrackName());
        txtRating.setText(String.valueOf(track.getTrackRating()));

        return listView;
    }
}
