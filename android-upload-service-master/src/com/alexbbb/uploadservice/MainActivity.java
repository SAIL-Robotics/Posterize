package com.alexbbb.uploadservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.File;
import java.net.URL;
import java.util.UUID;

/**
 * Activity that demonstrates how to use Android Upload Service.
 *
 * @author Alex Gotev
 *
 */
public class MainActivity extends Activity {

    private static final String TAG = "AndroidUploadServiceDemo";

    private ProgressBar progressBar;
    private Button uploadButton;
    private Button cancelUploadButton;
    private EditText serverUrl;
    private EditText fileToUpload;
    private EditText parameterName;

    private final AbstractUploadServiceReceiver uploadReceiver = new AbstractUploadServiceReceiver() {

        @Override
        public void onProgress(String uploadId, int progress) {
            progressBar.setProgress(progress);

            //Log.i(TAG, "progress upload " + uploadId);
        }

        @Override
        public void onError(String uploadId, Exception exception) {
            progressBar.setProgress(0);

            String message = "Error in upload with ID: " + uploadId + ". " + exception.getLocalizedMessage();
            //Log.e(TAG, message, exception);
        }

        @Override
        public void onCompleted(String uploadId, int serverResponseCode, String serverResponseMessage) {
            progressBar.setProgress(0);

            String message = "Upload with ID " + uploadId + " is completed: " + serverResponseCode + ", "
                    + serverResponseMessage;
            //Log.i(TAG, message);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set your application namespace to avoid conflicts with other apps
        // using this library
        UploadService.NAMESPACE = "com.Posterize";

        progressBar = (ProgressBar) findViewById(R.id.uploadProgress);
        serverUrl = (EditText) findViewById(R.id.serverURL);
        fileToUpload = (EditText) findViewById(R.id.fileToUpload);
        parameterName = (EditText) findViewById(R.id.parameterName);
        uploadButton = (Button) findViewById(R.id.uploadButton);
        cancelUploadButton = (Button) findViewById(R.id.cancelUploadButton);

        uploadButton.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                onUploadButtonClick();
            }
        });

        cancelUploadButton.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                onCancelUploadButtonClick();
            }
        });

        progressBar.setMax(100);
        progressBar.setProgress(0);

        // De-comment this line to enable self-signed SSL certificates in HTTPS connections
        // WARNING: Do not use in production environment. Recommended for development only
        // AllCertificatesAndHostsTruster.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        uploadReceiver.register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        uploadReceiver.unregister(this);
    }

    private boolean userInputIsValid(final String serverUrlString, final String fileToUploadPath,
                                     final String paramNameString) {
        if (serverUrlString.length() == 0) {
            Toast.makeText(this, getString(R.string.provide_valid_server_url), Toast.LENGTH_LONG).show();
            return false;
        }

        try {
            new URL(serverUrlString.toString());
        } catch (Exception exc) {
            Toast.makeText(this, getString(R.string.provide_valid_server_url), Toast.LENGTH_LONG).show();
            return false;
        }

        if (fileToUploadPath.length() == 0) {
            Toast.makeText(this, getString(R.string.provide_file_to_upload), Toast.LENGTH_LONG).show();
            return false;
        }

        if (!new File(fileToUploadPath).exists()) {
            Toast.makeText(this, getString(R.string.file_does_not_exist), Toast.LENGTH_LONG).show();
            return false;
        }

        if (paramNameString.length() == 0) {
            Toast.makeText(this, getString(R.string.provide_param_name), Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }

    private void onUploadButtonClick() {
        final String serverUrlString = serverUrl.getText().toString();
        final String fileToUploadPath = fileToUpload.getText().toString();
        final String paramNameString = parameterName.getText().toString();

        if (!userInputIsValid(serverUrlString, fileToUploadPath, paramNameString))
            return;

        final UploadRequest request = new UploadRequest(this, UUID.randomUUID().toString(), serverUrlString);

        request.addFileToUpload(fileToUploadPath, paramNameString, "test", ContentType.APPLICATION_OCTET_STREAM);

        request.setNotificationConfig(R.drawable.ic_launcher, getString(R.string.app_name),
                getString(R.string.uploading), getString(R.string.upload_success),
                getString(R.string.upload_error), false);

        // if you comment the following line, the system default user-agent will be used
        request.setCustomUserAgent("UploadServiceDemo/1.0");

        // set the intent to perform when the user taps on the upload notification.
        // currently tested only with intents that launches an activity
        // if you comment this line, no action will be performed when the user taps on the notification
        request.setNotificationClickIntent(new Intent(this, MainActivity.class));

        // set the maximum number of automatic upload retries on error
        request.setMaxRetries(2);

        try {
            UploadService.startUpload(request);
        } catch (Exception exc) {
            Toast.makeText(this, "Malformed upload request. " + exc.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void onCancelUploadButtonClick() {
        UploadService.stopCurrentUpload();
    }
}
