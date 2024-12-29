package co.edu.uniquindio.poo.MoveTemplate;

public class MoveTemplate {
    private String name;
    private String description;
    private int valor;
    private String type;

    public MoveTemplate(String name, String description, int valor, String tipo) {
        this.name = name;
        this.description = description;
        this.valor = valor;
        this.type = tipo;
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

    


}
