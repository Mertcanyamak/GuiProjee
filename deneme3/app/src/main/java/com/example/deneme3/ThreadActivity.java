package com.example.deneme3;

        import android.content.Intent;
        import android.graphics.Bitmap;
        import android.graphics.BitmapFactory;
        import android.os.AsyncTask;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ImageView;
        import android.widget.Toast;

        import java.io.IOException;
        import java.io.InputStream;
        import java.net.URL;

public class ThreadActivity  extends MainActivity {
    EditText etUrl;
    Button btClear,btSubmit,save;
    ImageView ivResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        etUrl =  findViewById(R.id.et_url);
        btClear = findViewById(R.id.bt_clear);
        btSubmit = findViewById(R.id.bt_submit);
        ivResult = findViewById(R.id.iv_result);
        save = findViewById(R.id.kaydet);

        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etUrl.setText("");
                ivResult.setImageBitmap(null);
            }
        });

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlLink = etUrl.getText().toString();
                if (urlLink.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please Enter Url !!!" ,Toast.LENGTH_SHORT).show();
                }else{
                    LoadImage loadImage = new LoadImage(ivResult);
                    loadImage.execute(urlLink);

                }


            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Log_outActivity.class);
                startActivity(intent);
            }
        });
    }
    class LoadImage extends AsyncTask<String,Void, Bitmap> {
        ImageView imageView;
        private LoadImage(ImageView ivResult) {
            this.imageView = ivResult;
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            String urlLink = strings[0];
            Bitmap bitmap = null;
            try {
                InputStream inputStream = new URL(urlLink).openStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            ivResult.setImageBitmap(bitmap);
        }
    }


}
