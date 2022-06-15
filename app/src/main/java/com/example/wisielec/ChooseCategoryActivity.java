package com.example.wisielec;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChooseCategoryActivity extends AppCompatActivity{

    TextView tvOptionAll;
    TextView tvOptionJedzenie;
    TextView tvOptionZwierzeta;
    TextView tvOptionSport;
    TextView tvOptionGeografia;
    TextView tvOptionFilm;
    TextView tvOptionInformatyka;
    String chosenCategory;
    Intent intentPassword;
    Context context;
    PasswordDatabase passwordDatabase;
    PasswordDao passwordDao;
    List<String> passwords;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        setContentView(R.layout.activity_choose_category);

        tvOptionAll = (TextView) findViewById(R.id.tvOptionAll);
        tvOptionJedzenie = (TextView) findViewById(R.id.tvOptionJedzenie);
        tvOptionZwierzeta = (TextView) findViewById(R.id.tvOptionZwierzeta);
        tvOptionSport = (TextView) findViewById(R.id.tvOptionSport);
        tvOptionGeografia = (TextView) findViewById(R.id.tvOptionGeografia);
        tvOptionFilm = (TextView) findViewById(R.id.tvOptionFilm);
        tvOptionInformatyka = (TextView) findViewById(R.id.tvOptionInformatyka);
        context = getApplicationContext();
        passwordDatabase = Room.databaseBuilder(context, PasswordDatabase.class, "password_database").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        passwordDao = passwordDatabase.passwordDao();
        intentPassword = new Intent(ChooseCategoryActivity.this, GuessPasswordActivity.class);
        Intent intentSameCategory = getIntent();
        boolean sameCat = intentSameCategory.getBooleanExtra("sameCat", false);



        //inserting data to password database
        //if(!isInsertedIntoDB) {
            passwordDao.insertAll(
                    //jedzenie
                    new Password("pomidor koktajlowy", "jedzenie"),
                    new Password("naleśnik z serem", "jedzenie"),
                    new Password("quesadilla", "jedzenie"),
                    new Password("kawa z mlekiem", "jedzenie"),
                    new Password("yerba mate", "jedzenie"),
                    new Password("jogurt naturalny", "jedzenie"),
                    new Password("płatki śniadaniowe", "jedzenie"),
                    new Password("spaghetti bolognese", "jedzenie"),
                    new Password("brownie", "jedzenie"),
                    new Password("jajecznica", "jedzenie"),
                    new Password("sałatka owocowa", "jedzenie"),
                    new Password("mandarynka", "jedzenie"),
                    new Password("biszkopt", "jedzenie"),
                    new Password("ciasto czekoladowe", "jedzenie"),
                    new Password("bita śmietana", "jedzenie"),
                    new Password("zupa pomidorowa", "jedzenie"),
                    new Password("puree ziemniaczane", "jedzenie"),
                    new Password("kotlet schabowy", "jedzenie"),
                    new Password("piwo jasne", "jedzenie"),
                    new Password("chleb pełnoziarnisty", "jedzenie"),
                    new Password("bułka", "jedzenie"),
                    new Password("sos beszamelowy", "jedzenie"),
                    new Password("pizza", "jedzenie"),
                    new Password("sernik", "jedzenie"),
                    new Password("ptyś", "jedzenie"),
                    new Password("mango", "jedzenie"),
                    new Password("ananas", "jedzenie"),
                    new Password("frytki", "jedzenie"),
                    new Password("krem śmietankowy", "jedzenie"),
                    new Password("cheeseburger", "jedzenie"),
                    new Password("ser", "jedzenie"),
                    new Password("pierniki", "jedzenie"),
                    new Password("mleko", "jedzenie"),
                    new Password("sól", "jedzenie"),


                    //zwierzęta
                    new Password("żuk", "zwierzeta"),
                    new Password("jeleń", "zwierzeta"),
                    new Password("anakonda zielona", "zwierzeta"),
                    new Password("waran z komodo", "zwierzeta"),
                    new Password("jeżozwierz", "zwierzeta"),
                    new Password("żarłacz biały", "zwierzeta"),
                    new Password("orka", "zwierzeta"),
                    new Password("sarna", "zwierzeta"),
                    new Password("wilk", "zwierzeta"),
                    new Password("niedźwiedź brunatny", "zwierzeta"),
                    new Password("rak", "zwierzeta"),
                    new Password("labrador", "zwierzeta"),
                    new Password("ryba", "zwierzeta"),
                    new Password("bóbr", "zwierzeta"),
                    new Password("kot", "zwierzeta"),
                    new Password("słoń", "zwierzeta"),
                    new Password("chomik", "zwierzeta"),
                    new Password("koala", "zwierzeta"),
                    new Password("panda", "zwierzeta"),
                    new Password("surykatka", "zwierzeta"),
                    new Password("zebra", "zwierzeta"),
                    new Password("megalodon", "zwierzeta"),
                    new Password("pterodaktyl", "zwierzeta"),
                    new Password("mysz", "zwierzeta"),
                    new Password("żółw", "zwierzeta"),
                    new Password("świnka morska", "zwierzeta"),
                    new Password("papuga ara", "zwierzeta"),
                    new Password("lew", "zwierzeta"),
                    new Password("tygrys", "zwierzeta"),
                    new Password("puma", "zwierzeta"),
                    new Password("lama", "zwierzeta"),
                    new Password("owca", "zwierzeta"),
                    new Password("byk", "zwierzeta"),
                    new Password("hipopotam", "zwierzeta"),
                    new Password("niedźwiedź polarny", "zwierzeta"),
                    new Password("kangur rudy", "zwierzeta"),
                    new Password("szop", "zwierzeta"),
                    new Password("łoś", "zwierzeta"),

                    //sport
                    new Password("piłka nożna", "sport"),
                    new Password("bieg z przeszkodami", "sport"),
                    new Password("gimnastyka", "sport"),
                    new Password("tour de pologne", "sport"),
                    new Password("kolarstwo górskie", "sport"),
                    new Password("siatkówka", "sport"),
                    new Password("trener", "sport"),
                    new Password("skoki narciarskie", "sport"),
                    new Password("łyżwierstwo figurowe", "sport"),
                    new Password("styl motylkowy", "sport"),
                    new Password("skok w dal", "sport"),
                    new Password("badminton", "sport"),
                    new Password("boisko", "sport"),
                    new Password("bramka", "sport"),
                    new Password("anita włodarczyk", "sport"),
                    new Password("bramkarz", "sport"),
                    new Password("bieżnia", "sport"),
                    new Password("skrzydłowy", "sport"),
                    new Password("rzut osobisty", "sport"),
                    new Password("górnik zabrze", "sport"),
                    new Password("aut", "sport"),
                    new Password("antenka", "sport"),
                    new Password("rakieta", "sport"),
                    new Password("tenis", "sport"),
                    new Password("windsurfing", "sport"),
                    new Password("narty", "sport"),
                    new Password("kibice", "sport"),
                    new Password("trybuna", "sport"),
                    new Password("rzut rożny", "sport"),
                    new Password("hokej", "sport"),

                    //geografia
                    new Password("eurazja", "geografia"),
                    new Password("osady atmosferyczne", "geografia"),
                    new Password("cieśnina bosfor", "geografia"),
                    new Password("morze północne", "geografia"),
                    new Password("karaiby", "geografia"),
                    new Password("ameryka południowa", "geografia"),
                    new Password("sahara", "geografia"),
                    new Password("syberia", "geografia"),
                    new Password("nigeria", "geografia"),
                    new Password("lizbona", "geografia"),
                    new Password("wyżyna tybetańska", "geografia"),
                    new Password("australia", "geografia"),
                    new Password("lodowiec", "geografia"),
                    new Password("gruzja", "geografia"),
                    new Password("morze czerwone", "geografia"),
                    new Password("madagaskar", "geografia"),
                    new Password("połonina caryńska", "geografia"),
                    new Password("tarnica", "geografia"),
                    new Password("rysy", "geografia"),
                    new Password("śnieżka", "geografia"),
                    new Password("alpy", "geografia"),
                    new Password("sudety", "geografia"),
                    new Password("śniardwy", "geografia"),
                    new Password("jezioro wiktorii", "geografia"),
                    new Password("nil", "geografia"),
                    new Password("amazonka", "geografia"),
                    new Password("huragan", "geografia"),
                    new Password("monsun", "geografia"),
                    new Password("mżawka", "geografia"),
                    new Password("mgła", "geografia"),
                    new Password("bytom", "geografia"),
                    new Password("san francisco", "geografia"),
                    new Password("ohio", "geografia"),
                    new Password("texas", "geografia"),
                    new Password("nowy jork", "geografia"),
                    new Password("tokio", "geografia"),
                    new Password("nairobi", "geografia"),
                    new Password("oslo", "geografia"),
                    new Password("dortmund", "geografia"),
                    new Password("mongolia", "geografia"),

                    //film
                    new Password("star wars", "film"),
                    new Password("harrison ford", "film"),
                    new Password("leonardo dicaprio", "film"),
                    new Password("indiana jones", "film"),
                    new Password("tom cruise", "film"),
                    new Password("ojciec mateusz", "film"),
                    new Password("władca pierścieni", "film"),
                    new Password("la casa de papel", "film"),
                    new Password("angelina jolie", "film"),
                    new Password("forrest gump", "film"),
                    new Password("m jak miłość", "film"),
                    new Password("klan", "film"),
                    new Password("jak zostałem gangsterem", "film"),
                    new Password("smerfy", "film"),
                    new Password("teletubisie", "film"),
                    new Password("kubuś puchatek", "film"),
                    new Password("tomek i przyjaciele", "film"),
                    new Password("reżyser", "film"),
                    new Password("scenarzysta", "film"),
                    new Password("scenografia", "film"),
                    new Password("operator kamery", "film"),
                    new Password("kino", "film"),
                    new Password("popcorn", "film"),
                    new Password("kryminał", "film"),
                    new Password("horror", "film"),
                    new Password("dramat", "film"),
                    new Password("komedia", "film"),
                    new Password("the mandalorian", "film"),
                    new Password("yoda", "film"),
                    new Password("król lew", "film"),
                    new Password("mała syrenka", "film"),
                    new Password("oscar", "film"),
                    new Password("listy do m", "film"),
                    new Password("spider man", "film"),
                    new Password("piraci z karaibów", "film"),
                    new Password("james bond", "film"),
                    new Password("ojciec chrzestny", "film"),
                    new Password("odyseja kosmiczna", "film"),
                    new Password("łowca androidów", "film"),
                    new Password("matrix", "film"),

                    //informatyka
                    new Password("usb typu c", "informatyka"),
                    new Password("dysk ssd", "informatyka"),
                    new Password("procesor", "informatyka"),
                    new Password("karta graficzna", "informatyka"),
                    new Password("klawiatura mechaniczna", "informatyka"),
                    new Password("monitor", "informatyka"),
                    new Password("wiersz poleceń", "informatyka"),
                    new Password("serwer", "informatyka"),
                    new Password("baza danych", "informatyka"),
                    new Password("płyta główna", "informatyka"),
                    new Password("piksel", "informatyka"),
                    new Password("pci express", "informatyka"),
                    new Password("paint", "informatyka"),
                    new Password("folder", "informatyka"),
                    new Password("antywirus", "informatyka"),
                    new Password("java script", "informatyka"),
                    new Password("minecraft", "informatyka"),
                    new Password("tomb raider", "informatyka"),
                    new Password("league of legends", "informatyka"),
                    new Password("windows", "informatyka"),
                    new Password("linux", "informatyka"),
                    new Password("intel", "informatyka"),
                    new Password("google", "informatyka"),
                    new Password("microsoft", "informatyka"),
                    new Password("internet explorer", "informatyka"),
                    new Password("słuchawki", "informatyka"),
                    new Password("menadżer zadań", "informatyka"),
                    new Password("gimp", "informatyka"),
                    new Password("excel", "informatyka"),
                    new Password("android", "informatyka")


            );



        if(sameCat){
            chosenCategory = intentSameCategory.getStringExtra("category");
            if(chosenCategory.equalsIgnoreCase("wszystkie")){
                passwords = passwordDao.getAll();
                int passwordsQuantily = passwords.size();
                int randomIndex = new Random().nextInt(passwordsQuantily);
                intentPassword.putExtra("password", passwords.get(randomIndex));
                intentPassword.putExtra("category", "wszystkie");
                startActivity(intentPassword);
            }
            else {
                passwords = passwordDao.findInSpecificCategory(chosenCategory);
                int passwordQuantily = passwords.size();
                int randomIndex = new Random().nextInt(passwordQuantily);
                intentPassword.putExtra("password", passwords.get(randomIndex));
                intentPassword.putExtra("category", chosenCategory);
                startActivity(intentPassword);
            }
        }

        intentPassword = new Intent(getApplicationContext(), GuessPasswordActivity.class);
        tvOptionAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passwords = passwordDao.getAll();
                int passwordsQuantily = passwords.size();
                int randomIndex = new Random().nextInt(passwordsQuantily);
                intentPassword.putExtra("password", passwords.get(randomIndex));
                intentPassword.putExtra("category", "wszystkie");
                startActivity(intentPassword);
            }
        });

        tvOptionJedzenie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chosenCategory = "jedzenie";
                passwords = passwordDao.findInSpecificCategory(chosenCategory);
                int passwordQuantily = passwords.size();
                int randomIndex = new Random().nextInt(passwordQuantily);
                intentPassword.putExtra("password", passwords.get(randomIndex));
                intentPassword.putExtra("category", chosenCategory);
                startActivity(intentPassword);
            }
        });

        tvOptionZwierzeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chosenCategory = "zwierzeta";
                passwords = passwordDao.findInSpecificCategory(chosenCategory);
                int passwordQuantily = passwords.size();
                int randomIndex = new Random().nextInt(passwordQuantily);
                intentPassword.putExtra("password", passwords.get(randomIndex));
                intentPassword.putExtra("category", chosenCategory);
                startActivity(intentPassword);
            }
        });

        tvOptionSport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chosenCategory = "sport";
                passwords = passwordDao.findInSpecificCategory(chosenCategory);
                int passwordQuantily = passwords.size();
                int randomIndex = new Random().nextInt(passwordQuantily);
                intentPassword.putExtra("password", passwords.get(randomIndex));
                intentPassword.putExtra("category", chosenCategory);
                startActivity(intentPassword);
            }
        });

        tvOptionGeografia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chosenCategory = "geografia";
                passwords = passwordDao.findInSpecificCategory(chosenCategory);
                int passwordQuantily = passwords.size();
                int randomIndex = new Random().nextInt(passwordQuantily);
                intentPassword.putExtra("password", passwords.get(randomIndex));
                intentPassword.putExtra("category", chosenCategory);
                startActivity(intentPassword);
            }
        });

        tvOptionFilm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chosenCategory = "film";
                passwords = passwordDao.findInSpecificCategory(chosenCategory);
                int passwordQuantily = passwords.size();
                int randomIndex = new Random().nextInt(passwordQuantily);
                intentPassword.putExtra("password", passwords.get(randomIndex));
                intentPassword.putExtra("category", chosenCategory);
                startActivity(intentPassword);
            }
        });

        tvOptionInformatyka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chosenCategory = "informatyka";
                passwords = passwordDao.findInSpecificCategory(chosenCategory);
                int passwordQuantily = passwords.size();
                int randomIndex = new Random().nextInt(passwordQuantily);
                intentPassword.putExtra("password", passwords.get(randomIndex));
                intentPassword.putExtra("category", chosenCategory);
                startActivity(intentPassword);
            }
        });
    }
}