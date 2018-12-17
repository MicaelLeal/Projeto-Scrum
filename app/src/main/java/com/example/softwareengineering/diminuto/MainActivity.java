package com.example.softwareengineering.diminuto;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.softwareengineering.diminuto.adapters.MainRvAdapter;
import com.example.softwareengineering.diminuto.models.Instrumento;
import com.example.softwareengineering.diminuto.models.Usuario;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView mRvMain;
    private FloatingActionButton fab;
    public static Usuario usuarioLogado;
    public static Usuario maria;
    public static List<Instrumento> instrumentos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerSetup(toolbar);
        ViewsSetup();

        persistencia();

    }

    private void persistencia() {
        usuarioLogado = new Usuario("João", "joao@joao.com",
                "1234", "1234-5678");

        maria = new Usuario("Maria", "maria@maria.com",
                "1234", "8765-4321");

        Instrumento guitarra = new Instrumento("Guitarra", "Seminova", maria, 50);
        instrumentos.add(guitarra);
        Instrumento violao = new Instrumento("Violão", "Usado", maria, 20);
        instrumentos.add(violao);
        Instrumento teclado = new Instrumento("Teclado", "Adaldf", maria, 60);
        instrumentos.add(teclado);

    }

    private void ViewsSetup() {

        fab = findViewById(R.id.fab);
        fab.setOnClickListener((view) -> {
            startActivity(new Intent(this, CadastroActivity.class));
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
        });

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mRvMain = findViewById(R.id.rv_main);

        instrumentos = new ArrayList<>();

    }

    private void drawerSetup(Toolbar toolbar) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    protected void onResume() {
        super.onResume();

        reloadMain();

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

        if (id == R.id.nav_main) {
            reloadMain();
        } else if (id == R.id.nav_meus_instrumentos) {
            fab.setVisibility(View.VISIBLE);
            reloadMeusInstrumentos();



        } else if (id == R.id.nav_instrumentos_alugados) {

        } else if (id == R.id.nav_sair) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void reloadMain(){
        fab.setVisibility(View.GONE);

        MainRvAdapter adapter = new MainRvAdapter(this, instrumentos);
        mRvMain.setAdapter(adapter);
        mRvMain.setLayoutManager(new LinearLayoutManager(this));
    }

    public void reloadMeusInstrumentos(){
        List<Instrumento> meusInstrumentos = new ArrayList<>();

        for (int i = 0; i < instrumentos.size(); i++){
            if (instrumentos.get(i).getDono().equals(usuarioLogado)){
                meusInstrumentos.add(instrumentos.get(i));
            }
        }
        MainRvAdapter adapter = new MainRvAdapter(this, meusInstrumentos);
        mRvMain.setAdapter(adapter);
        mRvMain.setLayoutManager(new LinearLayoutManager(this));
    }

}
