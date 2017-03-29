package com.example.root.shit.view;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.root.shit.R;
import com.example.root.shit.events.CaptureEvent;
import com.github.chrisbanes.photoview.PhotoView;
import com.github.chrisbanes.photoview.PhotoViewAttacher;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }

    @BindView(R.id.ivFeedBottom)
    PhotoView imageView;

    @BindView(R.id.btnLike)
    ImageButton btnLike;


    @BindView(R.id.toolbar_main2)
    Toolbar toolbar;

    private   Boolean isFavorite = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        ((AppCompatActivity)getActivity()).getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);

        View view =  inflater.inflate(R.layout.fragment_main2, container, false);

        ButterKnife.bind(this, view);

        toolbar.setTitle("Time's Up");

        PhotoViewAttacher yourAttacher = new PhotoViewAttacher(imageView);
        yourAttacher.setZoomable(true);


        btnLike.setOnClickListener(v -> {


            if (isFavorite) {
                v.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.rotate));

                btnLike.setImageDrawable(v.getResources().getDrawable(R.drawable.ic_heart_outline_grey));
                isFavorite = false;
            } else {
                v.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.rotate));

                btnLike.setImageDrawable(v.getResources().getDrawable(R.drawable.ic_heart_red));
                isFavorite = true;
            }
        });



        return view;
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onCaptureEvent(CaptureEvent captureEvent){
        Bitmap bitmap = captureEvent.getBitmap();
//        bitmap.setHeight(200);
        imageView.setImageBitmap(bitmap);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
