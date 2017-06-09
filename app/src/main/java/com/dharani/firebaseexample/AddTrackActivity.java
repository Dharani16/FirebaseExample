package com.dharani.firebaseexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddTrackActivity extends AppCompatActivity {

    TextView textviewArtistName,tvRating;
    EditText edtName;
    SeekBar seekBar;
    Button btAdd;
    ListView listviewTracks;
    DatabaseReference databaseTracks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_track);

        textviewArtistName = (TextView)findViewById(R.id.textViewArtist);
        edtName = (EditText)findViewById(R.id.etNameTrack);
        seekBar = (SeekBar)findViewById(R.id.seekBarRating);
        tvRating = (TextView)findViewById(R.id.textViewRating);
        btAdd = (Button)findViewById(R.id.buttonAddTrack);
        listviewTracks = (ListView)findViewById(R.id.listViewTracks);

        Intent inte = getIntent();
        String id = inte.getStringExtra(MainActivity.ARTIST_ID);
        String name = inte.getStringExtra(MainActivity.ARTIST_NAME);

        textviewArtistName.setText(name);
        databaseTracks = FirebaseDatabase.getInstance().getReference("tracks").child(id);
        
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveTrack();
            }
        });
    }

    private void saveTrack() {
        String trackName = edtName.getText().toString();
        int rating = seekBar.getProgress();
        if (!TextUtils.isEmpty(trackName)){
            String id = databaseTracks.push().getKey();
            Track track = new Track(id,trackName,rating);
            databaseTracks.child(id).setValue(track);
            Toast.makeText(this, "Track saved successfully", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Track name should not be empty", Toast.LENGTH_SHORT).show();
        }
    }
}
