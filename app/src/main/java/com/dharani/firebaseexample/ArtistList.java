package com.dharani.firebaseexample;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
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

public class ArtistList extends ArrayAdapter<Artist> {
    private Activity context;
    private List<Artist> artistList;

    public ArtistList(Activity context, List<Artist> artistList) {
        super(context, R.layout.list_layout, artistList);
        this.context = context;
        this.artistList = artistList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listView = inflater.inflate(R.layout.list_layout,null,true);

        TextView txtName = (TextView)listView.findViewById(R.id.textView_Name);
        TextView txtGenre = (TextView)listView.findViewById(R.id.textView_Genre);

        Artist artist = artistList.get(position);

        txtName.setText(artist.getArtistName());
        txtGenre.setText(artist.getArtistGenre());

        return listView;
    }
}
