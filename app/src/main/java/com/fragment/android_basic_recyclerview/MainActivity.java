package com.fragment.android_basic_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recycler_view)
    RecyclerView rv;

    ArrayList<President> list;

    //ini adalah data yang mau kita masukkan
    public static String[][] data = new String[][]{
            {"Soekarno", "Presiden Pertama RI", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/Presiden_Sukarno.jpg/418px-Presiden_Sukarno.jpg"},
            {"Soeharto", "Presiden Kedua RI", "https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/President_Suharto%2C_1993.jpg/468px-President_Suharto%2C_1993.jpg"},
            {"Bacharuddin Jusuf Habibie", "Presiden Ketiga RI", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f1/Bacharuddin_Jusuf_Habibie_official_portrait.jpg/520px-Bacharuddin_Jusuf_Habibie_official_portrait.jpg"},
            {"Abdurrahman Wahid", "Presiden Keempat RI", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/President_Abdurrahman_Wahid_-_Indonesia.jpg/486px-President_Abdurrahman_Wahid_-_Indonesia.jpg"},
            {"Megawati Soekarnoputri", "Presiden Kelima RI", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/88/President_Megawati_Sukarnoputri_-_Indonesia.jpg/540px-President_Megawati_Sukarnoputri_-_Indonesia.jpg"},
            {"Susilo Bambang Yudhoyono", "Presiden Keenam RI", "https://upload.wikimedia.org/wikipedia/commons/5/58/Presiden_Susilo_Bambang_Yudhoyono.png"},
            {"Joko Widodo", "Presiden Ketujuh RI", "https://upload.wikimedia.org/wikipedia/commons/1/1c/Joko_Widodo_2014_official_portrait.jpg"}
    };

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setData();
    }

    //untuk menampilkan data kedalam recycler view setelah setData()
    private void showRecyclerView() {
        rv.setLayoutManager((new LinearLayoutManager(this)));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, list);
        rv.setAdapter(adapter);
    }

    //simpan data kedalam Class President
    public void setData(){
        President president = null;

        list = new ArrayList<>();

        for (int i = 0; i <data.length; i++) {
            president = new President();
            president.setName(data[i][0]);
            president.setRemarks(data[i][1]);
            president.setPhoto(data[i][2]);

            list.add(president);
        }

        showRecyclerView(); //setelah selesai penyimpanan barulah munculkan kedalam recyler view
    }
}
