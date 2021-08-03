/**
 * Implementação da classe CD e suas funcionalidades
 * @author Giovani B. Pinzetta & Guilherme Manfroi
 * @version 1.0
 * @since 2021
 * 
 */

public class CD {
    private Integer id;
    private Integer tempo;
    private Integer contagem;
    
    public CD(Integer id, Integer tipo){
        this.id = id;
        //se o disco é do tipo 0, ele vai ter um tempo de 5 a 7, se for outro tipo terá tempo de 9 a 12
        this.tempo = (tipo == 0 ? 5 : 9) + (int)(Math.random() * (tipo == 0 ? 3 : 4)); //Gera um tempo de 5 a 7 ou de 9 a 12 unidades de tempo dependendo do tipo;
        contagem = 0; //vezes que aquele disco foi ouvido
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the tempo
     */
    public Integer getTempo() {
        return tempo;
    }

    /**
     * @param tempo the tempo to set
     */
    public void setTempo(Integer tempo) {
        this.tempo = tempo;
    }

    /**
     * @return the contagem
     */
    public Integer getContagem() {
        return contagem;
    }

    /**
     * @param contagem the contagem to set
     */
    public void somaContagem() {
        this.contagem++; //acrescenta 1 na contagem do disco, toda vez que ele é ouvido
    }
}
