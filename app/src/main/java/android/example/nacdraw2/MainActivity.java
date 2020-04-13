package android.example.nacdraw2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.Toolbar;
import android.widget.VideoView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.tulbar);
        setSupportActionBar(toolbar);


        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer , R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.framelay,
                    new Fragment1()).commit();
            navigationView.setCheckedItem(R.id.home);}
        }

    private void setSupportActionBar(Toolbar toolbar) {
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelay,
                        new Fragment1()).commit();
                break;
            case R.id.running:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelay,
                        new Fragment2()).commit();
                break;
            case R.id.berlari:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelay,
                        new Fragment3()).commit();
                break;
            case R.id.basket:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelay,
                        new Fragment4()).commit();
                break;
            case R.id.bultang:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelay,
                        new Fragment5()).commit();
                break;
            case R.id.berenang:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelay,
                        new Fragment6()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }


}