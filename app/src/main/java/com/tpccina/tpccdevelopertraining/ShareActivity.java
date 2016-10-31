package com.tpccina.tpccdevelopertraining;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toolbar;

/**
 * Provides the landing screen of this sample. There is nothing particularly interesting here. All
 * the codes related to the Direct Share feature are in {@link SampleChooserTargetService}.
 */
public class ShareActivity extends Activity {

    private EditText mEditBody;
    private ImageButton mShare;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        setActionBar((Toolbar) findViewById(R.id.toolbar));
        mEditBody = (EditText) findViewById(R.id.body);
        mShare = (ImageButton) findViewById(R.id.share);
        //findViewById(R.id.share).setOnClickListener(mOnClickListener);
        mShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.share:
                        share();
                        break;
                }
            }
        });
    }

    /*private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.share:
                    share();
                    break;
            }
        }
    };*/

    /**
     * Emits a sample share {@link Intent}.
     */
    private void share() {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, mEditBody.getText().toString());
        startActivity(Intent.createChooser(sharingIntent, getString(R.string.send_intent_title)));
    }

}
