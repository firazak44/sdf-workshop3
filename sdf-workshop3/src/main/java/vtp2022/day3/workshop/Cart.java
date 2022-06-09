package vtp2022.day3.workshop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

public class Cart {
    private List<String> contents = new LinkedList<>();
    private String username;

    public Cart(String name){
        this.username = name;
    }

    public String getUsername(){
        return username;
    }

    public void add(String item){
        for(String inCart: contents)
            if(inCart.equals(item))
                return;
        contents.add(item);
    }

    public String delete(int index){
        if(index < contents.size())
            return contents.remove(index);
        return "nothing";
    }

    public void load(InputStream is)throws IOException{
        InputStreamReader isr = new InputStreamReader(is); //raw input
        BufferedReader br = new BufferedReader(isr); //line by line
        String item;
        while((item = br.readLine()) != null)
            contents.add(item);
        br.close(); //claiming back from last out, sequential
        isr.close();
    }

    public void save(OutputStream os) throws IOException{
        OutputStreamWriter ows = new OutputStreamWriter(os); //no need for "first in - last out" sequence
        BufferedWriter bw = new BufferedWriter(ows);
        for(String item: contents)
            bw.write(item + "\n");
        ows.flush();
        bw.flush();
        ows.close();
        bw.close();
    }
    
    public List<String> getContents(){
        return contents;
    }
}
