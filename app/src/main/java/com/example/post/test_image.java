//package com.example.post;
//
//import android.os.Bundle;
//import android.widget.ImageView;
//
//import androidx.appcompat.app.AppCompatActivity;
//import com.squareup.picasso.Picasso;
//
//
//public class item_post extends AppCompatActivity {
//
//    private ImageView img;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.test_image);
//
//        ImageView imageView = findViewById(R.id.imageView);
//        String imageUrl = "https://ik.imagekit.io/v57xrgddo/default-image.jpg?updatedAt=1685863954920";
//
//        Picasso.get()
//                .load(imageUrl)
//                .into(imageView);
//
//        ImageKit imageKit = ImageKit.getInstance();
//        Configuration config = new Configuration(your_public_key, your_private_key, your_url_endpoint);
//        imageKit.setConfig(config);
//    }
//}