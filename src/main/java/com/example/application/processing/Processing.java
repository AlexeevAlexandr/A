package com.example.application.processing;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Processing {

    public List getLinks(){
        List<String> list = new ArrayList<>();
        try (Scanner sc = new Scanner(new File("src\\main\\resources\\html.csv"))){
            while (sc.hasNext()){
                list.add(sc.nextLine());
            }
        }catch (Exception e){e.printStackTrace();}
        return list;
    }
}
