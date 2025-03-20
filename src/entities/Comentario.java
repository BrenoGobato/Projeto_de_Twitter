package entities;

public class Comentario {

    private String texto_comentario;

    public Comentario(){
    }

    public Comentario(String texto_comentario){
        this.texto_comentario = texto_comentario;
    }

    public String getTexto_comentario() {
        return texto_comentario;
    }

    public void setTexto_comentario(String texto_comentario) {
        this.texto_comentario = texto_comentario;
    }
}
