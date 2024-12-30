package co.edu.uniquindio.poo.MoveTemplate;

public class MoveTemplate {
    private String name;
    private String description;
    private int valor;
    private String type;
    private String date;

    public MoveTemplate(String name, String description, int valor, String tipo, String date) {
        this.name = name;
        this.description = description;
        this.valor = valor;
        this.type = tipo;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getValor() {
        return valor;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }
    

    


}
