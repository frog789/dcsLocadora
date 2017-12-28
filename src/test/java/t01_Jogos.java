import com.dsclocadora.entities.Categoria;
import com.dsclocadora.entities.FaixaEtariaEnum;
import com.dsclocadora.entities.Idioma;
import com.dsclocadora.entities.Jogo;
import com.dsclocadora.entities.Produtora;
import com.dsclocadora.services.IdiomaService;
import com.dsclocadora.services.JogoService;
import com.dsclocadora.services.ProdutoraService;
import java.time.Instant;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rapha
 */
public class t01_Jogos extends Testes {
    
    private JogoService jogoService;
    private IdiomaService idiomaService;
    private ProdutoraService produtoraService;
    
    @Before
    public void setUp() throws NamingException {
        jogoService = (JogoService) container.getContext().lookup("java:global/classes/ejb/JogoService!com.dscloadora.services.JogoService");
        idiomaService = (IdiomaService) container.getContext().lookup("java:global/classes/ejb/IdiomaService!com.dscloadora.services.IdiomaService");
        produtoraService = (ProdutoraService) container.getContext().lookup("java:global/classes/ejb/ProdutoraService!com.dscloadora.services.ProdutoraService");
    }
    
    @After
    public void tearDown() {
        jogoService = null; 
    }

     @Test
     public void newJogo() {
         Jogo jogo = jogoService.criar();
         Idioma idioma = idiomaService.consultarPorId(new Long(1));     
         Produtora prod = produtoraService.consultarPorId(new Long (2));
         Categoria cat = new Categoria();
         List<Categoria> lcat = new ArrayList<>();
         cat.setNomeCategoria("Suspense");
         lcat.add(cat);
         
         jogo.setAudioIdioma(idioma);
         jogo.setCategorias(lcat);
         jogo.setClassificacao(FaixaEtariaEnum.L);
         jogo.setCriador("Nobuo Uematsu");
         jogo.setDtLancamento(Date.from(Instant.now()));
         jogo.setLegendaIdioma(idioma);
         jogo.setProdutora(prod);
         jogo.setQtdDisponivel(4);
         jogo.setQtdJogadores(4);
         jogo.setTamanhoGB(Double.MAX_VALUE);
         jogo.setTitulo("GOD OF FANTASY");
         jogo.setValorJogo(Double.MAX_VALUE);
         jogo.setValorLocacao(Double.MAX_VALUE);
     }
}
