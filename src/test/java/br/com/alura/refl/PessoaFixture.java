package br.com.alura.refl;

import br.com.alura.Pessoa;

public class PessoaFixture {
    static Pessoa buildPessoa() {
        return new Pessoa(32, "João", "12345");
    }


}
