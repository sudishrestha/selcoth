package np.com.sudishrestha.selcouthstreamer;


import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import java.util.ArrayList;
import java.util.List;

import np.com.sudishrestha.selcouthstreamer.helper.messageAdapter;
import np.com.sudishrestha.selcouthstreamer.helper.viewerAdapter;
import np.com.sudishrestha.selcouthstreamer.model.messages;

public class streamer extends LinearLayout {

    private List<messages> messagesList = new ArrayList<>();
    private List<messages> viewerlist = new ArrayList<>();

    private RecyclerView recyclerView,rvViewer;
    RelativeLayout topmenu,profDetail,bottom_section;
    private messageAdapter mAdapter;
    viewerAdapter radapter;
    PlayerView pvMain;
    boolean hideElement;

    private void initialize(Context context){
       View view =  inflate(context, R.layout.selcouth_view, this);
        pvMain = findViewById(R.id.exoplayerview_activity_video);
        pvMain = findViewById(R.id.exoplayerview_activity_video);
        topmenu = findViewById(R.id.topmenu);
        profDetail = findViewById(R.id.profDetail);
        bottom_section = findViewById(R.id.bottom_section);

        String CONTENT_URL = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4";
        int playerID = R.id.exoplayerview_activity_video;
        startPlayingVideo(context, CONTENT_URL, playerID);
        recyclerView = (RecyclerView) findViewById(R.id.messages);
        rvViewer = (RecyclerView) findViewById(R.id.viewers);

        pvMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hideElement)
                {
                    recyclerView.setVisibility(View.VISIBLE);
                    rvViewer.setVisibility(View.VISIBLE);
                    topmenu.setVisibility(View.VISIBLE);
                    profDetail.setVisibility(View.VISIBLE);
                    bottom_section.setVisibility(View.VISIBLE);
                    hideElement = false;
                }
                else
                {
                    recyclerView.setVisibility(View.GONE);
                    rvViewer.setVisibility(View.GONE);
                    topmenu.setVisibility(View.GONE);
                    profDetail.setVisibility(View.GONE);
                    bottom_section.setVisibility(View.GONE);
                    hideElement= true;
                }
            }
        });
        mAdapter = new messageAdapter(messagesList,true,context);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);



        radapter = new viewerAdapter(viewerlist,false,context);
        RecyclerView.LayoutManager mLayoutManagers = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false);
        rvViewer.setLayoutManager(mLayoutManagers);
        rvViewer.setItemAnimator(new DefaultItemAnimator());
        rvViewer.setAdapter(radapter);


        prepareData();
    }
    public streamer(Context context) {
        super(context);
        initialize(context);
    }

    public streamer(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }
    private void prepareData() {
        messages messages = new messages("Mad Max: Fury Road", "Action & Adventure");
        messagesList.add(messages);

        messages = new messages("Mad Max: Fury Road", "Action & Adventure");
        messagesList.add(messages);
        messages = new messages("Mad Max: Fury Road", "Action & Adventure");
        messagesList.add(messages);
        messagesList.add(messages);
//        viewerlist = messagesList;


        messages viewers = new messages("Mad Max: Fury Road", "Action & Adventure");
        viewerlist.add(viewers);

        viewers = new messages("Mad Max: Fury Road", "Action & Adventure");
        viewerlist.add(messages);
        viewers = new messages("Mad Max: Fury Road", "Action & Adventure");
        viewerlist.add(messages);
        viewers = new messages("Mad Max: Fury Road", "Action & Adventure");
        viewerlist.add(messages);
        viewers = new messages("Mad Max: Fury Road", "Action & Adventure");
        viewerlist.add(messages);


        radapter.notifyDataSetChanged();
        mAdapter.notifyDataSetChanged();
    }
    private void startPlayingVideo(Context ctx, String CONTENT_URL, int playerID) {

        //BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
        //TrackSelection.Factory videoTrackSelectionFactory = new AdaptiveTrackSelection.Factory(bandwidthMeter);
        //TrackSelector trackSelectorDef = new DefaultTrackSelector(videoTrackSelectionFactory);
        TrackSelector trackSelectorDef = new DefaultTrackSelector();
        SimpleExoPlayer absPlayerInternal = ExoPlayerFactory.newSimpleInstance(ctx, trackSelectorDef);
        String userAgent = Util.getUserAgent(ctx, "selcouthStreamer");
        DefaultDataSourceFactory defdataSourceFactory = new DefaultDataSourceFactory(ctx, userAgent);
        Uri uriOfContentUrl = Uri.parse(CONTENT_URL);
        MediaSource mediaSource = new ProgressiveMediaSource.Factory(defdataSourceFactory).createMediaSource(uriOfContentUrl);
        absPlayerInternal.prepare(mediaSource);
        absPlayerInternal.setPlayWhenReady(true);
        pvMain.setPlayer(absPlayerInternal);
    }

    private void stopPlayer(PlayerView pv, SimpleExoPlayer absPlayer) {
        pv.setPlayer(null);
        absPlayer.release();
        absPlayer = null;
    }
}