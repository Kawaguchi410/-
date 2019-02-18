package karatakushi.io.lfs_;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public List<ClipData.Item> getSampleData() {
        List<Item> items = new ArrayList<>();

        items.add(new Item("タイトル1", "内容1", 1));
        items.add(new Item("タイトル2", "内容2", 2));
        items.add(new Item("タイトル3", "内容3", 3));
        items.add(new Item("タイトル4", "内容4", 4));
        items.add(new Item("タイトル5", "内容5", 5));
        items.add(new Item("タイトル6", "内容6", 6));
        items.add(new Item("タイトル7", "内容7", 7));
        items.add(new Item("タイトル8", "内容8", 8));
        items.add(new Item("タイトル9", "内容9", 9));

        return items;
    }
}
