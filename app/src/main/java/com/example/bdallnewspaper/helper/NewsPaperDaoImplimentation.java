package com.example.bdallnewspaper.helper;

import com.example.bdallnewspaper.model.Newspaper;
import com.example.bdallnewspaper.R;
import java.util.ArrayList;
import java.util.List;

public class NewsPaperDaoImplimentation implements NewsPaperDao {

    @Override
    public List<Newspaper> banglaNewspaper() {

        List<Newspaper> fierstnewspaper = new ArrayList<>();

        fierstnewspaper.add(new Newspaper(R.drawable.prothom_alo,"https://www.prothomalo.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.bangladeshbulateen,"http://bd-bulletin.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.bangladeshprotidin,"https://www.bd-pratidin.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.bonikbtra,"https://bonikbarta.net/"));
        fierstnewspaper.add(new Newspaper(R.drawable.gonokonntho,"http://www.dailyjanakantha.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.ittefaq,"https://www.ittefaq.com.bd/"));
        fierstnewspaper.add(new Newspaper(R.drawable.jagoron,"https://www.dailyjagaran.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.jonokontho,"http://www.gonokantho.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.kalerkontho,"https://www.kalerkantho.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.notunbatra,"http://www.natun-barta.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.orthonitirkagoj,"https://arthoniteerkagoj.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.sarabangla,"https://www.ajkerpatrika.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.sharebiz,"https://sharebiz.net/"));
        fierstnewspaper.add(new Newspaper(R.drawable.somokal,"https://samakal.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.sorejomin,"http://sorejominbarta.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.vorerkagoj,"http://www.bhorerkagoj.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.vorerpata,"https://dailyvorerpata.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.amadershomoy,"http://www.dainikamadershomoy.com/"));

        return fierstnewspaper;

    }

    @Override
    public List<Newspaper> englishNewspaper() {
        List<Newspaper> fierstnewspaper = new ArrayList<>();

        fierstnewspaper.add(new Newspaper(R.drawable.daily_star,"https://www.thedailystar.net/"));
        fierstnewspaper.add(new Newspaper(R.drawable.dailyasianage,"https://dailyasianage.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.dhakatribune,"https://www.dhakatribune.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.dailysun,"https://www.daily-sun.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.energybangla,"https://energybangla.com.bd/"));
        fierstnewspaper.add(new Newspaper(R.drawable.newagebd,"https://epaper.newagebd.net/"));
        fierstnewspaper.add(new Newspaper(R.drawable.newstoday,"http://www.newstoday.com.bd/"));
        fierstnewspaper.add(new Newspaper(R.drawable.observerbd,"https://www.observerbd.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.thebangladeshtoday,"https://thebangladeshtoday.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.thedailynewnation,"http://thedailynewnation.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.thefinancialexpress,"https://thefinancialexpress.com.bd/"));
        fierstnewspaper.add(new Newspaper(R.drawable.theindependentbd,"http://www.theindependentbd.com/online/world-news"));
        fierstnewspaper.add(new Newspaper(R.drawable.weeklyholiday,"https://www.weeklyholiday.net/"));
        return fierstnewspaper;
    }

    @Override
    public List<Newspaper> topNewspaper() {
        List<Newspaper> fierstnewspaper = new ArrayList<>();

        fierstnewspaper.add(new Newspaper(R.drawable.banglanews,"https://www.banglanews24.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.banglatribune,"https://www.banglatribune.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.bbcbangla,"https://www.bbc.com/bengali"));
        fierstnewspaper.add(new Newspaper(R.drawable.bdlive,"https://www.bd24live.com/bangla/"));
        fierstnewspaper.add(new Newspaper(R.drawable.bdjournal,"https://www.bd-journal.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.bdnews,"http://bdnews24.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.dhakatimes,"https://www.dhakatimes24.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.gonews,"https://www.gonews24.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.jagonews,"https://www.jagonews24.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.risingbd,"https://www.risingbd.com/"));
        return fierstnewspaper;
    }

    @Override
    public List<Newspaper> allNewspaper() {
        List<Newspaper> fierstnewspaper = new ArrayList<>();
        fierstnewspaper.add(new Newspaper(R.drawable.amadershomoy,"https://www.amadershomoy.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.bangladeshpress,"https://bangladeshpress.com.bd/"));
        fierstnewspaper.add(new Newspaper(R.drawable.barta,"https://barta24.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.bartabazar,"http://bartabazar.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.bdcrictime,"https://www.bdcrictime.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.bdmorning,"https://www.bdmorning.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.bnbdlogo,"https://www.breakingnews.com.bd/"));
        fierstnewspaper.add(new Newspaper(R.drawable.currentnewsdotcom,"http://www.currentnews.com.bd/"));
        fierstnewspaper.add(new Newspaper(R.drawable.dailybangladesh,"https://www.daily-bangladesh.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.dainikshiksha,"http://www.dainikshiksha.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.dmpnews,"https://dmpnews.org/"));
        fierstnewspaper.add(new Newspaper(R.drawable.insaf,"https://insaf24.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.newsbangladesh,"http://www.newsbangladesh.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.onenewsbd,"https://www.onenewsbd.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.pbdnews,"https://www.ppbd.news/"));
        fierstnewspaper.add(new Newspaper(R.drawable.primenewsbd,"http://www.primenewsbd.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.priyo,"https://www.priyo.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.sarabangla,"https://sarabangla.net/"));
        fierstnewspaper.add(new Newspaper(R.drawable.shikshabarta,"https://shikshabarta.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.thedailycampus,"https://www.thedailycampus.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.unbnews,"https://www.unbnews.org/"));
        fierstnewspaper.add(new Newspaper(R.drawable.voabangla,"https://www.voabangla.com/"));
        fierstnewspaper.add(new Newspaper(R.drawable.youthcarnival,"https://www.youthcarnival.org/"));
        fierstnewspaper.add(new Newspaper(R.drawable.zoombangla,"https://zoombangla.com/"));
        return fierstnewspaper;
    }
}
