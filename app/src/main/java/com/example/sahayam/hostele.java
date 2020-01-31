package com.example.sahayam;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
public class hostele extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView videoView = findViewById(R.id.video_view1);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.demo1;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);



        VideoView videoView1= findViewById(R.id.video_view2);
        String videoPath1 = "android.resource://" + getPackageName() + "/" + R.raw.demo1;
        Uri uri1 = Uri.parse(videoPath1);
        videoView1.setVideoURI(uri1);

        MediaController mediaController1 = new MediaController(this);
        videoView1.setMediaController(mediaController1);
        mediaController1.setAnchorView(videoView1);


        VideoView videoView2 = findViewById(R.id.video_view3);
        String videoPath2 = "android.resource://" + getPackageName() + "/" + R.raw.demo1;
        Uri uri2 = Uri.parse(videoPath2);
        videoView2.setVideoURI(uri2);

        MediaController mediaController2 = new MediaController(this);
        videoView2.setMediaController(mediaController2);
        mediaController2.setAnchorView(videoView2);
    }


}
