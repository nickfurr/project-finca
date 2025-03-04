package co.edu.uniquindio.poo.MoveTemplate;

public class MoveTemplateBuilder {
    private String name;
    private String description;
    private int valor;
    private String type;
    private String date;
    
    public void setName(String name) {
        this.name = name;
    }
    public MoveTemplateBuilder setDescription(String description) {
        this.description = description;
        return this;
    }
    public MoveTemplateBuilder setValor(int valor) {
        this.valor = valor;
        return this;
    }
    public MoveTemplateBuilder setType(String tipo) {
        this.type = tipo;
        return this;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public MoveTemplate build(){
        return new MoveTemplate (this.name, this.description, this.valor, this.type, this.date);
    }
    
    
}
