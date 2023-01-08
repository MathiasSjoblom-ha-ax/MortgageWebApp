package com.webapp.MortgageWebApp.repositories;

import com.webapp.MortgageWebApp.entities.Customer;
import com.webapp.MortgageWebApp.services.CustomerService;
import org.springframework.context.annotation.Bean;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CustomerRepository implements CustomerService {

    ArrayList<Customer> customerList = new ArrayList<>();
    //Samlar också upp attributen i textfilens första rad ifall man vill göra det mer dynamiskt iframtiden
    ArrayList<String> attributeList = new ArrayList<>();
    String fileName = "src/main/resources/txtFile/prospects.txt";
    BufferedReader br;

    //Inläsning av fil med variabel deklaration
    {
        try {
            br = new BufferedReader(new FileReader(fileName));
            int lineCount = 0;
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().length() < 8) {
                    continue; //Skippar de tomma skräp raderna i text filen ifall de inte har minst 7 täcken (en för varje kolumn samt kommatecknet)
                }
                int count = 0;

                //Rengöring av onödiga täcken i filen specifikt att ta bort komma tecknet mellan Clarencé,Andersson i filen (får max finnas tre komma tecken per rad)
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == ',') {
                        count++;
                        if (count > 3) {
                            line = line.replaceFirst(",", " ");
                        }
                    }
                }
                //Rengöring av onödiga täcken i filen
                line = line.replaceAll("\"", "");
                String[] parts = line.split(",");

                //Den första raden i filen med alla attribut sätts in i en separat variabel
                if (lineCount == 0) {
                    attributeList.addAll(Arrays.asList(parts));
                    lineCount++;
                    continue;
                }
                for (int i = 0; i < parts.length; i++) {
                    if (parts[i].contains(".")) {
                        String[] newString = parts[i].split("\\.");
                        parts[i] = parts[i].replaceAll("\\.", ",");
                        double integer = Integer.parseInt(newString[0]);
                        double decimal = Integer.parseInt(newString[1]);
                        parts[i] = String.valueOf(integer + decimal / 100);
                    }
                }
                try {
                    customerList.add(new Customer(parts[0], Double.parseDouble(parts[1]), Double.parseDouble(parts[2]), Integer.parseInt(parts[3])));
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }
                lineCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }


    public ArrayList<String> getAttributeList() {
        return attributeList;
    }

    public void addCustomer(Customer customer) {
        this.customerList.add(customer);
    }
}
