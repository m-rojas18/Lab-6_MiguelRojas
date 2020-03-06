package lab6_miguelrojas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin_usuario {


    private ArrayList<Usuario> listaUsuarios = new ArrayList();
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

    @Override
    public String toString() {
        return "listaUsuarios=" + listaUsuarios;
    }
    
    public void cargarArchivoU(){
        Scanner sc = null;
        listaUsuarios = new ArrayList();
        try {
            if (archivoU.exists()) {
                sc = new Scanner(archivoU);
                sc.useDelimiter(";");
                while(sc.hasNext()){
                    listaUsuarios.add(new Usuario(sc.next(), sc.next(), sc.next(), sc.next()));
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
