package karatakushi.io.lfs_;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView titleText;
    TextView contentText;
    TextView likeCount;
    ImageButton likeImage;
    Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        titleText = findViewById(R.id.title);
        contentText = findViewById(R.id.content);
        likeCount = findViewById(R.id.likeCount);
        likeImage = findViewById(R.id.likeImage);

        item = (Item)getIntent().getSerializableExtra("ItemData");

        titleText.setText(item.title);
        contentText.setText(item.content);
        likeCount.setText(item.likeCount + "Likes");
        if (item.isLiked){
            likeImage.setBackgroundResource(R.drawable.heart);
        }else {
            likeImage.setBackgroundResource(R.drawable.emptyheart);
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(item.title);
        }
    }

    public void LikeButton(View v){
//        if (item.isLiked){
//            likeImage.setBackgroundResource(R.drawable.emptyheart);
//            item.likeCount--;
//            likeCount.setText(item.likeCount + "Likes");
//            item.isLiked = false;
//        }else {
//
//            likeImage.setBackgroundResource(R.drawable.heart);
//            item.likeCount++;
//            likeCount.setText(item.likeCount + "Likes");
//            item.isLiked = true;
//        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
