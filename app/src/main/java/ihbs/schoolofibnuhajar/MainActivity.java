package ihbs.schoolofibnuhajar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        // Tambahkan Manager
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ftr = fm.beginTransaction();

        if (id == R.id.profil) {
            // Handle the camera action
            Profil fp = new Profil();
            fp.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.container, fp, "PROFILE").commit();
            getSupportFragmentManager().popBackStack();

        } else if (id == R.id.webViewweb) {
            Web ep = new Web();
            ep.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.container, ep, "WEBSITE").commit();
            getSupportFragmentManager().popBackStack();

        } else if (id == R.id.webViewihp){
            Webihp ip = new Webihp();
            ip.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.container, ip, "HAJJ AND UMRAH").commit();
            getSupportFragmentManager().popBackStack();

        } else if (id == R.id.webviewvideoihbs) {
            VideoIHBS yt = new VideoIHBS();
            yt.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.container, yt, "IHBSTV").commit();
            getSupportFragmentManager().popBackStack();

        } else if (id == R.id.btnimagesohib) {
            RadioMoslem ip = new RadioMoslem();
            ip.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.container, ip, "ISLAMIC RADIO").commit();
            getSupportFragmentManager().popBackStack();

        } else if (id == R.id.imagecontactperson) {
            ContactPerson cp = new ContactPerson();
            cp.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.container, cp, "CONTACT PERSON").commit();
            getSupportFragmentManager().popBackStack();

        } else if (id == R.id.nav_share) {
            Intent sh = new Intent(Intent.ACTION_SEND);
            sh.setType("text/plain");
            sh.putExtra(Intent.EXTRA_SUBJECT, "APLIKASI RESMI");
            sh.putExtra(Intent.EXTRA_TEXT, "SCHOOL OF IBNU HAJAR : http://ihbs.or.id");
            startActivity(Intent.createChooser(sh, "Share Link"));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
