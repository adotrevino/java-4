import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class phonebook {
    HashMap<String, String> contactMap = new HashMap<>();
    String[] contactArr;
    
    public void loadContacts() {
        BufferedReader reader;
        String inputFile = "/Users/adolfotrevino/Documents/Tecmi/java/act-4/phone book/src/input.csv";

        try{
            reader = new BufferedReader(new FileReader(inputFile));
            String line;
            while((line = reader.readLine()) != null){
               
                contactArr = line.split(",");
                contactMap.put(contactArr[0], contactArr[1]);
            }
        }catch(IOException e){ 
            System.out.println("error al leer archivo: "+e.getMessage());
        }
        
       
    }

    public void display(){
        System.out.println("Agenda Completa: ");
        for(HashMap.Entry<String, String> entry: contactMap.entrySet()){
            String number = entry.getKey();
            String name = entry.getValue();
            System.out.println("Nombre: "+name+" Número: "+number);
        }
    }
    public void addContact(){
        Scanner scan = new Scanner(System.in);
        String name;
        String number;
        System.out.println("Nombre: ");
        name = scan.nextLine();
        System.out.println("Número: ");
        number = scan.nextLine();
        contactMap.put(number, name);
    }
    public void removeContact(){
        Scanner scan = new Scanner(System.in);
        String number;        
        
        System.out.println("Número que contacto que deseas eliminar: ");
        number = scan.nextLine();       
        
        while(contactMap.containsKey(number) == false){
            System.out.println("Número no existe, intenta de nuevo: ");
            number = scan.nextLine();
        }
        String returned_value = (String)contactMap.remove(number);
        System.out.println("Contacto eliminado: " + returned_value);
    }

    public void saveContacts(){
        BufferedWriter writer;
        String outputtFile = "/Users/adolfotrevino/Documents/Tecmi/java/act-4/phone book/src/output.csv";
        try{
            writer = new BufferedWriter(new FileWriter(outputtFile));
            String line;
            for(HashMap.Entry<String, String> entry: contactMap.entrySet()){
                String number = entry.getKey();
                String name = entry.getValue();
                line = number+","+name;               
                writer.write(line+"\n");
                
            }
            writer.close();
        }catch(IOException e){
            System.out.println("error al guardar archivo: "+e.getMessage());
        }
        
    }
}   
