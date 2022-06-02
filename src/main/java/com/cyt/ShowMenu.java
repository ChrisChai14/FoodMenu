package com.cyt;

import java.io.*;
import java.util.*;

public class ShowMenu {
    Map<String, Foods> menu = new HashMap<>();
    public ShowMenu() {
        File file = new File("menu.txt");
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line = in.readLine();
            while (line != null) {
                String[] tokens = line.split(",");
                Foods foods = new Foods(
                        tokens[0],
                        tokens[1],
                        Integer.parseInt(tokens[2]),
                        Integer.parseInt(tokens[3]));
                menu.put(foods.id, foods);
                line = in.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("讀取菜單失敗");
        }
    }

    public void printMenu() {
        for (Map.Entry<String, Foods> foodsEntry : menu.entrySet()) {
            System.out.println(foodsEntry.getValue());
        }
    }

    public static void main(String[] args) {
        ShowMenu showMenu = new ShowMenu();
        showMenu.printMenu();
    }
}
class Foods {
    String id;
    String name;
    int calorie;
    int price;

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + calorie + "\t" + price;
    }

    public Foods(String id, String name, int calorie, int price) {
        this.id = id;
        this.name = name;
        this.calorie = calorie;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}