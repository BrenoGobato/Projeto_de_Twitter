import entities.Post;
import entities.Comentario;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        int opcao;
        List<Post> posts = new ArrayList<>();

        System.out.println("--------------********************************************> MENU <********************************************---------------");
        System.out.println("1 - Fazer post | 2 - Remover post | 3 - Adicionar comentário | 4 - Remover comentário | 5- Like | 6 - Remover like | 7 - Sair");

        do {
            System.out.println("\nO que deseja fazer: ");
            opcao = sc.nextInt();
            sc.nextLine(); // Consumir quebra de linha pendente

            switch (opcao) {
                case 1:
                    System.out.print("Digite um título para o seu post: ");
                    String titulo = sc.nextLine();
                    System.out.print("Escreva o seu post: ");
                    String conteudo = sc.nextLine();
                    int likes = 0;
                    Date momento_post = new Date();

                    Post novoPost = new Post(momento_post, titulo, conteudo, likes);
                    posts.add(novoPost);
                    break;

                case 2:
                    if (posts.isEmpty()) {
                        System.out.println("Não há posts para remover.");
                        break;
                    }
                    System.out.println("Escolha o número do post para remover:");
                    for (int i = 0; i < posts.size(); i++) {
                        System.out.println(i + " - " + posts.get(i).getTitulo_post());
                    }
                    int postRemover = sc.nextInt();
                    if (postRemover >= 0 && postRemover < posts.size()) {
                        posts.remove(postRemover);
                        System.out.println("Post removido com sucesso.");
                    } else {
                        System.out.println("Post inválido.");
                    }
                    break;

                case 3:
                    if (posts.isEmpty()) {
                        System.out.println("Não há posts para comentar.");
                        break;
                    }
                    System.out.println("Escolha o número do post para comentar:");
                    for (int i = 0; i < posts.size(); i++) {
                        System.out.println(i + " - " + posts.get(i).getTitulo_post());
                    }
                    int postIndex = sc.nextInt();
                    sc.nextLine(); // Consumir quebra de linha pendente

                    if (postIndex >= 0 && postIndex < posts.size()) {
                        System.out.print("Digite seu comentário: ");
                        String textoComentario = sc.nextLine();
                        Comentario comentario = new Comentario(textoComentario);
                        posts.get(postIndex).addComentario(comentario);
                        System.out.println("Comentário adicionado!");
                    } else {
                        System.out.println("Post inválido.");
                    }
                    break;

                case 4:
                    if (posts.isEmpty()) {
                        System.out.println("Não há posts para remover comentários.");
                        break;
                    }
                    System.out.println("Escolha o número do post para remover um comentário:");
                    for (int i = 0; i < posts.size(); i++) {
                        System.out.println(i + " - " + posts.get(i).getTitulo_post());
                    }
                    int postComentario = sc.nextInt();
                    sc.nextLine();

                    if (postComentario >= 0 && postComentario < posts.size()) {
                        List<Comentario> comentarios = posts.get(postComentario).getComentarios();
                        if (comentarios.isEmpty()) {
                            System.out.println("Esse post não tem comentários.");
                            break;
                        }
                        System.out.println("Escolha o número do comentário para remover:");
                        for (int i = 0; i < comentarios.size(); i++) {
                            System.out.println(i + " - " + comentarios.get(i).getTexto_comentario());
                        }
                        int comentarioRemover = sc.nextInt();
                        if (comentarioRemover >= 0 && comentarioRemover < comentarios.size()) {
                            comentarios.remove(comentarioRemover);
                            System.out.println("Comentário removido com sucesso.");
                        } else {
                            System.out.println("Comentário inválido.");
                        }
                    } else {
                        System.out.println("Post inválido.");
                    }
                    break;

                case 5:
                    if (posts.isEmpty()) {
                        System.out.println("Não há posts para dar likes.");
                        break;
                    }
                    System.out.println("Escolha o número do post que voce curtiu:");
                    for (int i = 0; i < posts.size(); i++) {
                        System.out.println(i + " - " + posts.get(i).getTitulo_post());
                    }

                    int postLiked = sc.nextInt();
                    sc.nextLine(); // Consumir quebra de linha pendente

                    if (postLiked >= 0 && postLiked < posts.size()) {
                        int quantidadeLikes = posts.get(postLiked).getLikes();
                        posts.get(postLiked).setLikes(quantidadeLikes + 1);
                        System.out.println("Post curtido! " + (quantidadeLikes + 1) + " likes");
                    } else {
                        System.out.println("Post inválido.");
                    }

                    break;

                case 6:
                    if (posts.isEmpty()) {
                        System.out.println("Não há posts para tirar o like.");
                        break;
                    }
                    System.out.println("Escolha o número do post que voce quer tirar o like:");
                    for (int i = 0; i < posts.size(); i++) {
                        System.out.println(i + " - " + posts.get(i).getTitulo_post());
                    }

                    int postDeslike = sc.nextInt();
                    sc.nextLine(); // Consumir quebra de linha pendente

                    if (posts.get(postDeslike).getLikes() == 0){
                        System.out.println("Post não tem nenhuma curtida.");
                        break;
                    }

                    if (postDeslike >= 0 && postDeslike < posts.size()) {
                        int quantidadeLikes = posts.get(postDeslike).getLikes();
                        posts.get(postDeslike).setLikes(quantidadeLikes - 1);
                        System.out.println("Like removido! " + (quantidadeLikes - 1) + " likes");
                    } else {
                        System.out.println("Post inválido.");
                    }
                    break;

                case 7:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

            // Sempre exibir os posts após cada ação
            System.out.println();
            System.out.println("--------------********************************************> MENU <********************************************---------------");
            System.out.println("1 - Fazer post | 2 - Remover post | 3 - Adicionar comentário | 4 - Remover comentário | 5- Like | 6 - Remover like | 7 - Sair");
            System.out.println("\n====== POSTS ATUAIS ======");
            if (posts.isEmpty()) {
                System.out.println("Nenhum post criado ainda.");
            } else {
                for (int i = 0; i < posts.size(); i++) {
                    System.out.println("Post " + i + ":\n" + posts.get(i));
                }
            }

        } while (opcao != 7);

        sc.close();
    }
}
