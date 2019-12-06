package Entidades;

public class Estudiante {

    public static final String TABLA="Estudiantes";
    public static final String QUERY_CREATE_TABLE="CREATE TABLE Estudiantes(ID INTEGER PRIMARY KEY AUTOINCREMENT,Nombre TEXT NOT NULL,Nota1 REAL NOT NULL," +
                                                    "Nota2 REAL NOT NULL,Nota3 REAL NOT NULL,Promedio REAL NOT NULL)";
    public static final  String[] FIELDS={"ID","Nombre","Nota1","Nota2","Nota3","Promedio"};
    private int ID;
    private String Nombre;
    private float Nota1;
    private float Nota2;
    private float Nota3;
    private float Proedio;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public float getNota1() {
        return Nota1;
    }

    public void setNota1(float nota1) {
        Nota1 = nota1;
    }

    public float getNota2() {
        return Nota2;
    }

    public void setNota2(float nota2) {
        Nota2 = nota2;
    }

    public float getNota3() {
        return Nota3;
    }

    public void setNota3(float nota3) {
        Nota3 = nota3;
    }

    public float getProedio() {
        return Proedio;
    }

    public void setProedio(float proedio) {
        Proedio = proedio;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
