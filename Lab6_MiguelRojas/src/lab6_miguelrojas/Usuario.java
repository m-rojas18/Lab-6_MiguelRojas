package lab6_miguelrojas;

public class Usuario {


    private String nombre;
    private String username;
    private String password;
    private String fecha_nacimiento;
    
    public Usuario(){
        
    }

    public Usuario(String nombre, String username, String password, String fecha_nacimiento) {
        this.nombre = nombre;
        this.username = username;
        this.password = password;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    @Override
    public String toString() {
        return username;
    }
    
    
}
