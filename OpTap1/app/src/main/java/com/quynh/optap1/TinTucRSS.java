package com.quynh.optap1;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TinTucRSS extends AppCompatActivity {
    private RecyclerView rvTinTuc;
    private ArrayList<TinTuc> dsTinTuc;
    private TinTucAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tin_tuc_rss);
        View mainView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        rvTinTuc = findViewById(R.id.rvTinTuc);
        dsTinTuc = new ArrayList<>();

        adapter = new TinTucAdapter(dsTinTuc, this);
        rvTinTuc.setLayoutManager(new LinearLayoutManager(this));
        rvTinTuc.setAdapter(adapter);

        // Gọi hàm tải RSS từ VNExpress (Chuyên mục Tin Mới Nhất)
    }
    private void taiDuLieuRSS(String rssUrl) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(() -> {
            ArrayList<TinTuc> danhSachTam = new ArrayList<>();
            try {
                URL url = new URL(rssUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)");
                connection.connect();
                InputStream inputStream = connection.getInputStream();

                // Công cụ đọc XML
                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                factory.setNamespaceAware(false);
                XmlPullParser parser = factory.newPullParser();
                parser.setInput(inputStream, null);

                int eventType = parser.getEventType();
                boolean isInsideItem = false;
                String title = "", link = "", pubDate = "";

                // Vòng lặp duyệt qua từng thẻ XML
                while (eventType != XmlPullParser.END_DOCUMENT) {
                    if (eventType == XmlPullParser.START_TAG) {
                        String tagName = parser.getName();

                        if (tagName.equalsIgnoreCase("item")) {
                            isInsideItem = true; // Bắt đầu một bài báo mới
                        } else if (isInsideItem) {
                            if (tagName.equalsIgnoreCase("title")) {
                                title = parser.nextText();
                            } else if (tagName.equalsIgnoreCase("link")) {
                                link = parser.nextText();
                            } else if (tagName.equalsIgnoreCase("pubdate")) {
                                pubDate = parser.nextText();
                            }
                        }
                    } else if (eventType == XmlPullParser.END_TAG && parser.getName().equalsIgnoreCase("item")) {
                        // Kết thúc thẻ <item>, lưu bài báo vào danh sách tạm
                        isInsideItem = false;
                        danhSachTam.add(new TinTuc(title, link, pubDate));
                    }
                    eventType = parser.next();
                }

                // Cập nhật giao diện trên luồng chính
                handler.post(() -> {
                    dsTinTuc.clear();
                    dsTinTuc.addAll(danhSachTam);
                    adapter.notifyDataSetChanged();
                });

            } catch (Exception e) {
                // Sửa lại đoạn Toast này để nó in thẳng lỗi ra màn hình
                final String thongBaoLoi = e.toString(); // Bắt lỗi
                Log.e("Loi_RSS", "Lỗi cụ thể: " + thongBaoLoi);

                handler.post(() -> {
                    // Hiển thị lỗi lên bằng Toast thật lâu (LENGTH_LONG)
                    Toast.makeText(TinTucRSS.this, "LỖI LÀ: " + thongBaoLoi, Toast.LENGTH_LONG).show();
                });
            }
        });
    }
}