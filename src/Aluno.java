
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Implementação da classe Aluno e suas funcionalidades
 * @author Giovani B. Pinzetta e Guilherme Manfroi
 * @version 1.0
 * @since 2021
 * 
 */
public class Aluno implements Runnable {

    private Integer alunoId;
    private ArrayBlockingQueue<CD> array = new ArrayBlockingQueue<CD>(20);
    private List<CD> listaAssistidos = new ArrayList<CD>();
    private List<CD> listaAuxiliar = new ArrayList<CD>();
    private Integer tempoDecorrido;
    private Integer faltamCDs;
    List<Integer> listDados;

    /**
     * 
     * @param array set ArrayBlockingQueue array param
     * @param id set id for Aluno
     * @param listaDados set listaDados param
     */
    public Aluno(ArrayBlockingQueue<CD> array, Integer id, List<Integer> listaDados) {
      this.array = array;
      this.tempoDecorrido = 0;
      this.faltamCDs = 10;
      this.alunoId = id;

      listDados = listaDados;
    }

    /**
     * Method run to run the thread
     */
    @Override
    public void run() {
        while (listaAssistidos.size() < 10) { //fica no loop até o aluno ter escutado 10 discos
            try {
                array.drainTo(listaAuxiliar, faltamCDs); //passa para a listaAuxiliar os discos disponiveis, mas no maximo a quantidade que falta
                
                while (!listaAuxiliar.isEmpty()) { //percorre a listaAuxiliar até passar por todos discos disponiveis

                    if (!listaAssistidos.contains(listaAuxiliar.get(0))) { //testa para ver se o elemento atual já foi 'escutado'

                        listaAssistidos.add(listaAuxiliar.get(0)); //passa para a listaAssistidos o disco atual

                        System.out.println("O aluno " + this.alunoId + " esta escutando o CD " + listaAuxiliar.get(0).getId()); //fala qual disco o aluno ouviu

                        Thread.sleep(listaAuxiliar.get(0).getId()); //faz a thread dormir pelo tempo necessario para escutar o disco

                        this.tempoDecorrido += listaAuxiliar.get(0).getTempo(); //acrescenta aquele tempo na contagem total da thread

                        listaAuxiliar.get(0).somaContagem(); //incrementa a quantidade de vezes que aquele disco foi escutado

                        array.add(listaAuxiliar.get(0)); //readiciona aquele disco ao array de disponiveis (que é o compratilhado)

                        listaAuxiliar.remove(0); //remove aquele elemento da listaAuxiliar, para ai passar para o proximo

                        faltamCDs--; //diminui a quantidade de discos que restam serem ouvidos

                    } else { //se o disco já foi escutado
                        array.add(listaAuxiliar.get(0)); //devolve o disco ao array de disponiveis (que é o compratilhado)
                        listaAuxiliar.remove(0); //remove aquele elemento da listaAuxiliar, para ai passar para o proximo
                    }
                }   
            }catch (Exception e) { //faz o catch para caso algum erro acontecer
                e.printStackTrace();
            }
        }

        String saida = "";

        for (int i = 0; i < listaAssistidos.size(); i++) {
            saida += "CD " + i + " - " + listaAssistidos.get(i).getId() + "\n"; //adiciona na string saida os discos que aquele aluno ouviu
        }
        
        //fala o ID do aluno, a quantidade de discos que ouviu (idealmente 10), e o tempo que levou para ouvi-los, juntamente com os discos
        System.out.println("Acabou... ID: " + alunoId + " - Size: " + listaAssistidos.size() + " - Tempo: " + this.tempoDecorrido + "ms\n" + saida);

        listDados.set(0, listDados.get(0) + tempoDecorrido);
        if(listDados.get(0) >= 1000)
          listDados.set(1, listDados.get(1) + 1);
        else 
          listDados.set(2, listDados.get(2) + 1);
        
    }

    public Integer getTempoDecorrido() {
      return tempoDecorrido;
    }
}
