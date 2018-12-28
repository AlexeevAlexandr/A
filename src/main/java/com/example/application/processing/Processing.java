package com.example.application.processing;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Processing {

    public List getLinks(String file){
        List<String> list = new ArrayList<>();
        try (Scanner sc = new Scanner(new File("src/main/resources/topicsLinks/" + file + ".csv"))){
            while (sc.hasNext()){
                list.add(sc.nextLine());
            }
        }catch (Exception e){e.printStackTrace();}
        return list;
    }

    public void setLinks(String topic, String link){
        try (FileWriter fileWriter = new FileWriter(new File("src/main/resources/topicsLinks/" + topic + ".csv"),true)){
            fileWriter.write(link + "\n");
        }catch (Exception e){e.printStackTrace();}
    }
}
