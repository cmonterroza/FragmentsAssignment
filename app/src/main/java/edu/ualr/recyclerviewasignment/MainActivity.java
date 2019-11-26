package edu.ualr.recyclerviewasignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import edu.ualr.recyclerviewasignment.adapter.DeviceListAdapter;
import edu.ualr.recyclerviewasignment.data.DataGenerator;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private DeviceListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initRecyclerView();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.Connect:
                Toast.makeText(this, "Showing Connected", Toast.LENGTH_SHORT).show();
                //
                return true;
            case R.id.Disconnect:
                Toast.makeText(this, "Showing Disconnected", Toast.LENGTH_SHORT).show();
                //
                return true;
            case R.id.Linked:
                if(item.isChecked() == true) {
                    Toast.makeText(this, "Showing Linked", Toast.LENGTH_LONG).show();
                    //
                    item.setChecked(false);
                    return true;
                }
                else {
                    Toast.makeText(this, "Hiding Linked", Toast.LENGTH_LONG).show();
                    //
                    item.setChecked(true);
                    return true;
                }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initRecyclerView(){
        mAdapter = new DeviceListAdapter(this);
        mRecyclerView = findViewById(R.id.devices_recycler_view);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.addAll(DataGenerator.getDevicesDataset(5));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
    }
}
