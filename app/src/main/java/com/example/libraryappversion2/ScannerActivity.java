package com.example.libraryappversion2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;

public class ScannerActivity extends AppCompatActivity {

    Bitmap myBitmap;
    TextView txtView;
    ImageView myImageView;
    Frame frame;
    SparseArray<Barcode> barcodes;
    BarcodeDetector detector;
    Barcode thisCode;
    SurfaceView surfaceView;
    CameraSource cameraSource;
    String ISBN = "";

    public void barcodeScan(){


        if(barcodes.size() > 0) {
            thisCode = barcodes.valueAt(0);
            if(thisCode.rawValue.charAt(0) == 'A' && thisCode.rawValue.charAt(thisCode.rawValue.length()-1) == 'A'){
                ISBN = thisCode.rawValue.substring(1,thisCode.rawValue.length()-1);
            } else ISBN = thisCode.rawValue;
            //searchActivity.setISBN(thisCode.rawValue);
            Log.i("Barcode Status", ISBN);

            returnResults(ISBN);
        } else Log.i("Barcode Status", "Not read");//Toast.makeText(getApplicationContext(), "Barcode not read", Toast.LENGTH_SHORT).show();


    }

    public void runScanner(){



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);



        surfaceView = (SurfaceView) findViewById(R.id.camera_preview);



        detector = new BarcodeDetector.Builder(this)
                .setBarcodeFormats( Barcode.DATA_MATRIX | Barcode.QR_CODE |  Barcode.EAN_13 | Barcode.CODABAR)
                .build();

        if(!detector.isOperational()){
            Toast.makeText(this, "Could not set up the detector!", Toast.LENGTH_LONG).show();

            return;
        }

        cameraSource = new CameraSource.Builder(this, detector)
                .setRequestedPreviewSize(640,480)
                .setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE)
                .build();

        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ScannerActivity.this, new String[] { Manifest.permission.CAMERA },1);


                    return;
                }
                try
                {
                    cameraSource.start(holder);
                } catch (IOException e)
                {
                    e.printStackTrace();
                }





            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                cameraSource.stop();
            }
        });

        detector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {

            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                barcodes = detections.getDetectedItems();

                barcodeScan();
                //ScannerActivity.this.finish();
            }
        });

    }

    public void returnResults(String ISBN){

        Intent intent=new Intent();
        intent.putExtra("ISBN",ISBN);
        setResult(2,intent);

        ScannerActivity.this.finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        // Quit if back is pressed
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
            returnResults(ISBN);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


}
