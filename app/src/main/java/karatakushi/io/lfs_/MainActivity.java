package karatakushi.io.lfs_;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ItemAdapter mItemAdapter;
    ListView mListView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = findViewById(R.id.listView);
        mItemAdapter = new ItemAdapter(this, R.layout.item, getSampleData());
        mListView.setAdapter(mItemAdapter);
        intent = new Intent(this,SecondActivity.class);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemAdapter.ViewHolder viewHolder = (ItemAdapter.ViewHolder)view.getTag();
                Log.d("content", String.valueOf(viewHolder.contentTextView.getText()));
                Item item = mItemAdapter.getItem(position);
                intent.putExtra("ItemData", item);
                intent.putExtra("num", 10);
                startActivity(intent);
            }
        });
    }

    public List<Item> getSampleData() {
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
