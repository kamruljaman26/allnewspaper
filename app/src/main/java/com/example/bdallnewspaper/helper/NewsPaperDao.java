package com.example.bdallnewspaper.helper;

import com.example.bdallnewspaper.model.Newspaper;
import java.util.List;

public interface NewsPaperDao {
    List<Newspaper> banglaNewspaper();
    List<Newspaper> englishNewspaper();
    List<Newspaper> topNewspaper();
    List<Newspaper> allNewspaper();
}
