package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Date momento_post;
    private String titulo_post;
    private String conteudo_post;
    private int likes;
    private List<Comentario> comentarios = new ArrayList<>();

    public Post() {
    }

    public Post(Date momento_post, String titulo_post, String conteudo_post, int likes) {
        this.momento_post = momento_post;
        this.titulo_post = titulo_post;
        this.conteudo_post = conteudo_post;
        this.likes = likes;
    }

    public Date getMomento_post() {
        return momento_post;
    }

    public void setMomento_post(Date momento_post) {
        this.momento_post = momento_post;
    }

    public String getTitulo_post() {
        return titulo_post;
    }

    public void setTitulo_post(String titulo_post) {
        this.titulo_post = titulo_post;
    }

    public String getConteudo_post() {
        return conteudo_post;
    }

    public void setConteudo_post(String conteudo_post) {
        this.conteudo_post = conteudo_post;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void addComentario(Comentario comentario){
        comentarios.add(comentario);
    }

    public void remComentario(Comentario comentario){
        comentarios.remove(comentario);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("----- " + titulo_post + " -----\n");
        sb.append(conteudo_post + "  \n\n");
        sb.append(likes); sb.append("- Likes     "); sb.append(sdf.format(momento_post) + "\n");
        sb.append("Comentarios: \n");
        for (Comentario c : comentarios){
            sb.append(c.getTexto_comentario() + "\n");
        }
        return sb.toString();

    }
}
