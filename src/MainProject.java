import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Implementação do método Main e inicialização das threads dos alunos
 * @author Giovani B. Pinzetta e Guilherme Manfroi
 * @version 1.0
 * @since 2021
 * 
 */
public class MainProject {

    /**
     * 
     * @param args set the param args
     * @throws InterruptedException throws InterruptedException if an error occurs
     */
  public static void main(String[] args) throws InterruptedException {
    ArrayBlockingQueue<CD> array = new ArrayBlockingQueue<CD>(20);

    List<Integer> listaDados = new ArrayList<Integer>(); // lista que guarda os dados descritos abaixo
    listaDados.add(0); // tempo total
    listaDados.add(0); // quantidade de alunos que terminaram depois de 1000 unidades
    listaDados.add(0); // quantidade de alunos que terminaram antes de 1000 unidades

    //gera os discos e os adiciona no arrayBlockingQueue
    for (int i = 0; i < 20; i++) {
      CD c = new CD(i, i < 10 ? 0 : 1); //tem um if ternario, se é menor que 10, o tipo do disco é 0 (tempo de 5 a 7) se não é tipo 1 (tempo de 9 a 12)
      array.add(c);
      System.out.println("Criou CD: " + c.getId());
    }

    //inicializa todas as threads de aluno
    
    Aluno threadAluno1 = new Aluno(array, 1, listaDados);
    Thread t1 = new Thread(threadAluno1);
    t1.start();
    
    Aluno threadAluno2 = new Aluno(array, 2, listaDados);
    Thread t2 = new Thread(threadAluno2);
    t2.start();
    
    Aluno threadAluno3 = new Aluno(array, 3, listaDados);
    Thread t3 = new Thread(threadAluno3);
    t3.start();
    
    Aluno threadAluno4 = new Aluno(array, 4, listaDados);
    Thread t4 = new Thread(threadAluno4);
    t4.start();
    
    Aluno threadAluno5 = new Aluno(array, 5, listaDados);
    Thread t5 = new Thread(threadAluno5);
    t5.start();
    
    Aluno threadAluno6 = new Aluno(array, 6, listaDados);
    Thread t6 = new Thread(threadAluno6);
    t6.start();
    
    Aluno threadAluno7 = new Aluno(array, 7, listaDados);
    Thread t7 = new Thread(threadAluno7);
    t7.start();
    
    Aluno threadAluno8 = new Aluno(array, 8, listaDados);
    Thread t8 = new Thread(threadAluno8);
    t8.start();
    
    Aluno threadAluno9 = new Aluno(array, 9, listaDados);
    Thread t9 = new Thread(threadAluno9);
    t9.start();
    
    Aluno threadAluno10 = new Aluno(array, 10, listaDados);
    Thread t10 = new Thread(threadAluno10);
    t10.start();
    
    Aluno threadAluno11 = new Aluno(array, 11, listaDados);
    Thread t11 = new Thread(threadAluno11);
    t11.start();
    
    Aluno threadAluno12 = new Aluno(array, 12, listaDados);
    Thread t12 = new Thread(threadAluno12);
    t12.start();
    
    Aluno threadAluno13 = new Aluno(array, 13, listaDados);
    Thread t13 = new Thread(threadAluno13);
    t13.start();
    
    Aluno threadAluno14 = new Aluno(array, 14, listaDados);
    Thread t14 = new Thread(threadAluno14);
    t14.start();
    
    Aluno threadAluno15 = new Aluno(array, 15, listaDados);
    Thread t15 = new Thread(threadAluno15);
    t15.start();
    
    Aluno threadAluno16 = new Aluno(array, 16, listaDados);
    Thread t16 = new Thread(threadAluno16);
    t16.start();
    
    Aluno threadAluno17 = new Aluno(array, 17, listaDados);
    Thread t17 = new Thread(threadAluno17);
    t17.start();
    
    Aluno threadAluno18 = new Aluno(array, 18, listaDados);
    Thread t18 = new Thread(threadAluno18);
    t18.start();
    
    Aluno threadAluno19 = new Aluno(array, 19, listaDados);
    Thread t19 = new Thread(threadAluno19);
    t19.start();
    
    Aluno threadAluno20 = new Aluno(array, 20, listaDados);
    Thread t20 = new Thread(threadAluno20);
    t20.start();
    
    Aluno threadAluno21 = new Aluno(array, 21, listaDados);
    Thread t21 = new Thread(threadAluno21);
    t21.start();
    
    Aluno threadAluno22 = new Aluno(array, 22, listaDados);
    Thread t22 = new Thread(threadAluno22);
    t22.start();
    
    Aluno threadAluno23 = new Aluno(array, 23, listaDados);
    Thread t23 = new Thread(threadAluno23);
    t23.start();
    
    Aluno threadAluno24 = new Aluno(array, 24, listaDados);
    Thread t24 = new Thread(threadAluno24);
    t24.start();
    
    Aluno threadAluno25 = new Aluno(array, 25, listaDados);
    Thread t25 = new Thread(threadAluno25);
    t25.start();
    
    Aluno threadAluno26 = new Aluno(array, 26, listaDados);
    Thread t26 = new Thread(threadAluno26);
    t26.start();
    
    Aluno threadAluno27 = new Aluno(array, 27, listaDados);
    Thread t27 = new Thread(threadAluno27);
    t27.start();
    
    Aluno threadAluno28 = new Aluno(array, 28, listaDados);
    Thread t28 = new Thread(threadAluno28);
    t28.start();
    
    Aluno threadAluno29 = new Aluno(array, 29, listaDados);
    Thread t29 = new Thread(threadAluno29);
    t29.start();
    
    Aluno threadAluno30 = new Aluno(array, 30, listaDados);
    Thread t30 = new Thread(threadAluno30);
    t30.start();

    Thread.sleep(2000); //faz a thread inicial dormir por 1000ms
    
    System.out.println("Tempo total: " + listaDados.get(0));
    System.out.println("Total de alunos que terminaram antes de 1000ms: " + listaDados.get(2));
    System.out.println("Total de alunos que terminaram depois de 1000ms: " + listaDados.get(1));
    
    //fala os discos juntamente com a quantidade de vezes que foram ouvidos
    for(CD cd : array){
      System.out.println("CD " + cd.getId() + " foi assistido " + cd.getContagem() + " vezes");
    }
  }
}
