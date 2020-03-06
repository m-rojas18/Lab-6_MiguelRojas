package lab6_miguelrojas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin_usuario {


    private ArrayList<Usuario> listaUsuarios = new ArrayList();
    private ArrayList<String> listaUsername = new ArrayList();
    private ArrayList<String> listaPasswords = new ArrayList();
    private File archivoU = null;
    
    public Admin_usuario(String path){
        archivoU = new File(path);
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public File getArchivoU() {
        return archivoU;
    }

    public void setArchivoU(File archivoU) {
        this.archivoU = archivoU;
    }

    public ArrayList<String> getListaUsername() {
        return listaUsername;
    }

    public void setListaUsername(ArrayList<String> listaUsername) {
        this.listaUsername = listaUsername;
    }

    public ArrayList<String> getListaPasswords() {
        return listaPasswords;
    }

    public void setListaPasswords(ArrayList<String> listaPasswords) {
        this.listaPasswords = listaPasswords;
    }
    
    //Extra Mutadores
    public void setUsername(String user){
        this.listaUsername.add(user);
    }
    
    public String getUser(int pos){
        return listaUsername.get(pos);
    }
    
    public void setPassword(String pass){
        this.listaPasswords.add(pass);
    }
    
    public String getPassword(int pos){
        return listaPasswords.get(pos);
    }

    @Override
    public String toString() {
        return "listaUsuarios=" + listaUsuarios;
    }    
    public void cargarArchivoU(){
        Scanner sc = null;
        Scanner sc2 = null;
        listaUsuarios = new ArrayList();
        listaUsername = new ArrayList();
        listaPasswords = new ArrayList();
        try {
            if (archivoU.exists()) {
                sc = new Scanner(archivoU);
                sc.useDelimiter(";");
                while(sc.hasNext()){
                    Usuario u = new Usuario(sc.next(), sc.next(), sc.next(), sc.next());
                    listaUsuarios.add(u);
                    listaUsername.add(u.getUsername());
                    listaPasswords.add(u.getPassword());
                }
            } 
        } catch (Exception e) {
        }
        sc.close();   
    }
    
    public void escribirArchivoU() throws IOException{
        
        FileWriter fw = null;
        BufferedWriter bw = null;
        
        try {
            fw = new FileWriter(archivoU, true);
            bw = new BufferedWriter(fw);
            
            for (Usuario lu : listaUsuarios) {
                bw.write(lu.getNombre() + ";");
                bw.write(lu.getUsername() + ";");
                bw.write(lu.getPassword() + ";");
                bw.write(lu.getFecha_nacimiento() + ";");
            }
            bw.flush();
            
        } catch (IOException e) {
        }
        bw.close();
        fw.close();    
    }   
}
