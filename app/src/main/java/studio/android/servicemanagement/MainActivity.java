package studio.android.servicemanagement;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState==null){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new PurchaseFragment()).commit();
        navigationView.setCheckedItem(R.id.purchase);}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.commenmenus,menu);
        return super.onCreateOptionsMenu(menu);
    }


        @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.purchase:
                getSupportFragmentManager().beginTransaction().replace
                        (R.id.fragment_container,new PurchaseFragment()).commit();
                break;

            case R.id.sale:
                getSupportFragmentManager().beginTransaction().replace
                        (R.id.fragment_container,new SaleFragment()).commit();
                break;


            case R.id.stock:
                getSupportFragmentManager().beginTransaction().replace
                        (R.id.fragment_container,new StockFragment()).commit();
                break;


            case R.id.customer_details:
                getSupportFragmentManager().beginTransaction().replace
                        (R.id.fragment_container,new CustomerDetailsFragment()).commit();
                break;

            case R.id.report:
                getSupportFragmentManager().beginTransaction().replace
                        (R.id.fragment_container,new ReportsFragment()).commit();
                break;

            case R.id.logout:
                Toast.makeText(this,"logout", Toast.LENGTH_SHORT).show();

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.mnuset) {
            Toast.makeText(this, "setting", Toast.LENGTH_SHORT).show();

        }

            return super.onOptionsItemSelected(item);
        }


        @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }


    }

}
