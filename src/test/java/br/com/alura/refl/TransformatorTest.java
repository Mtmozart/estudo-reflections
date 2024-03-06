package br.com.alura.refl;

import br.com.alura.Endereco;
import br.com.alura.Pessoa;
import br.com.alura.PessoaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

public class TransformatorTest {
    Pessoa pessoa = PessoaFixture.buildPessoa();
 Endereco endereco = new Endereco("Rua 10", 20);

    @Test
    public void shouldTransform() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
      Transformator tranfomator =  new Transformator();
      PessoaDTO pessoaDTO = tranfomator.transform(pessoa);
        Assertions.assertInstanceOf(PessoaDTO.class, pessoaDTO);
        Assertions.assertEquals(pessoa.getNome(),pessoaDTO.getNome());
        Assertions.assertEquals(pessoa.getCpf(),pessoaDTO.getCpf());
    }

    @Test
    public void shouldNotTransform() {
        Assertions.assertThrows(ClassNotFoundException.class,  () -> {
            Transformator tranfomator =  new Transformator();
            PessoaDTO pessoaDTO = tranfomator.transform(endereco);
        });
    }
    @Test
    public void shouldTransformWhenSomeFieldIsNull() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
      Pessoa pessoaSemCPF = new Pessoa("João");
        Transformator tranfomator =  new Transformator();
        PessoaDTO pessoaDTOSEmCpf = tranfomator.transform(pessoaSemCPF);
        Assertions.assertEquals(pessoa.getNome(), pessoaSemCPF.getNome());
        Assertions.assertNull(pessoaDTOSEmCpf.getCpf());
    }

}
