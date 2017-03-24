package com.example.root.shit.view;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.birbit.android.jobqueue.JobManager;
import com.example.root.shit.AppJobManager;
import com.example.root.shit.R;
import com.example.root.shit.jobs.CaptureJob;
import com.flurgle.camerakit.CameraListener;
import com.flurgle.camerakit.CameraView;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class CameraFragment extends Fragment {


    public CameraFragment() {
        // Required empty public constructor
    }

    @BindView(R.id.camera)
    CameraView mCameraView;

    @BindView(R.id.ibtn_capture)
    ImageButton btnCapture;
    Bitmap image;

    JobManager jobManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_camera, container, false);

        ButterKnife.bind(this, view);

        jobManager = AppJobManager.getJobManager();


        mCameraView.setCameraListener(new CameraListener() {
            @Override
            public void onPictureTaken(byte[] picture) {
                super.onPictureTaken(picture);

                // Create a bitmap
                Bitmap result = BitmapFactory.decodeByteArray(picture, 0, picture.length);

                Log.d("Came", result.getByteCount() + "");

                if (result.getByteCount() > 0){
//                    image = Bitmap.createBitmap(result);

                    btnCapture.setImageBitmap(result);
                    jobManager.addJobInBackground(new CaptureJob(result));
                }


            }
        });


        btnCapture.setOnClickListener(v -> {


            mCameraView.captureImage();
        });


        return view;


    }


    @Override
    public void onResume() {
        super.onResume();
        mCameraView.start();
    }

    @Override
    public void onPause() {
        mCameraView.stop();
        super.onPause();
    }


}
