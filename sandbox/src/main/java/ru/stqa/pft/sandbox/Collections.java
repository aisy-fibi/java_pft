package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

  public static void main(String[] args){
    String[] langs = {"Java","C#","Python","PHP"};//это массив

    //List<String> languages = new ArrayList<String>();это список
    List<String> languages = Arrays.asList("Java","C#","Python","PHP"); // преобразование массива в список

    for (int i = 0; i< languages.size(); i++){ // длина списка - функция list.size();
      System.out.println("Я хочу выучить " + languages.get(i)); // чтобы получить итый элемент списка - list.get(i)
    }
  }
}
