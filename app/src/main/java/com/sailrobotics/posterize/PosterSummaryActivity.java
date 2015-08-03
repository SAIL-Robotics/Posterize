package com.sailrobotics.posterize;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.List;


public class PosterSummaryActivity extends Activity {

    TextView imagePath,numberOfSheets,orientationType;
    ImageButton googleDriveButton,facebookButton,twitterButton,instagramButton;
    String pdfPath,orientation;
    String sheetsCount,fileName;
    Button openPdfButton;
    String shareURL;
    boolean isUploaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poster_summary);

        imagePath = (TextView)findViewById(R.id.filePath);
        numberOfSheets = (TextView)findViewById(R.id.totalSheets);
        orientationType = (TextView)findViewById(R.id.imageOrientation);
        openPdfButton = (Button)findViewById(R.id.generatePdfButton);
        googleDriveButton = (ImageButton) findViewById(R.id.driveImageButton);
        facebookButton = (ImageButton) findViewById(R.id.facebookImageButton);
        twitterButton = (ImageButton) findViewById(R.id.twitterImageButton);

        Intent intent = getIntent();
        pdfPath = intent.getStringExtra("pdfPath");
        fileName = intent.getStringExtra("FileName");
        sheetsCount = intent.getStringExtra("sheets");
        orientation = intent.getStringExtra("orientation");

        shareURL = "http://192.168.1.163/AndroidFileUpload/uploads/" + fileName;

        numberOfSheets.setText(sheetsCount);
        imagePath.setText(pdfPath);
        orientationType.setText(orientation);

        uploadPDFtoServer();

        googleDriveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Google Drive", Toast.LENGTH_SHORT).show();
                Intent googleDriveActivityIntent = new Intent(PosterSummaryActivity.this, GoogleDriveActivity.class);
                googleDriveActivityIntent.putExtra("FilePath", pdfPath);
                googleDriveActivityIntent.putExtra("FileName", fileName);
                startActivity(googleDriveActivityIntent);
            }
        });

        facebookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isUploaded)
                {
                    uploadPDFtoServer();
                }

                Intent tweetIntent = new Intent(Intent.ACTION_SEND);
                tweetIntent.putExtra(Intent.EXTRA_TEXT, "Check out the new poster I created using @posterize_app " + shareURL);
                tweetIntent.setType("text/plain");

                PackageManager packManager = getPackageManager();
                List<ResolveInfo> resolvedInfoList = packManager.queryIntentActivities(tweetIntent,  PackageManager.MATCH_DEFAULT_ONLY);

                boolean resolved = false;
                for(ResolveInfo resolveInfo: resolvedInfoList){
                    if(resolveInfo.activityInfo.packageName.startsWith("com.whatsapp")){
                        tweetIntent.setClassName(
                                resolveInfo.activityInfo.packageName,
                                resolveInfo.activityInfo.name );
                        resolved = true;
                        break;
                    }
                }
                if(resolved){
                    startActivity(tweetIntent);
                }else{
                    Toast.makeText(getApplicationContext(), "Whatsapp app isn't found", Toast.LENGTH_LONG).show();
                }
            }
        });

        twitterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isUploaded)
                {
                    uploadPDFtoServer();
                }
                Intent tweetIntent = new Intent(Intent.ACTION_SEND);
                tweetIntent.putExtra(Intent.EXTRA_TEXT, "Check out the new poster I created using @posterize_app " + shareURL);
                tweetIntent.setType("text/plain");

                PackageManager packManager = getPackageManager();
                List<ResolveInfo> resolvedInfoList = packManager.queryIntentActivities(tweetIntent,  PackageManager.MATCH_DEFAULT_ONLY);

                boolean resolved = false;
                for(ResolveInfo resolveInfo: resolvedInfoList){
                    if(resolveInfo.activityInfo.packageName.startsWith("com.twitter.android")){
                        tweetIntent.setClassName(
                                resolveInfo.activityInfo.packageName,
                                resolveInfo.activityInfo.name );
                        resolved = true;
                        break;
                    }
                }
                if(resolved){
                    startActivity(tweetIntent);
                }else{
                    Toast.makeText(getApplicationContext(), "Twitter app isn't found", Toast.LENGTH_LONG).show();
                }
            }
        });


        openPdfButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = new File(pdfPath);
                Intent target = new Intent(Intent.ACTION_VIEW);
                target.setDataAndType(Uri.fromFile(file),"application/pdf");
                target.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

                Intent intent = Intent.createChooser(target, "Open File");
                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    // Instruct the user to install a PDF reader here, or something
                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_poster_summary, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void uploadPDFtoServer()
    {
        Intent googleDriveActivityIntent = new Intent(PosterSummaryActivity.this,UploadPDFWebServer.class);
        googleDriveActivityIntent.putExtra("FilePath",pdfPath);
        googleDriveActivityIntent.putExtra("FileName",fileName);
        startActivity(googleDriveActivityIntent);
        isUploaded = true;
    }

    @Override
    public void onResume()
    {
        super.onResume();
        isUploaded = false;
    }
}
