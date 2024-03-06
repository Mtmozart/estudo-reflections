package br.com.alura.refl;

import br.com.alura.Pessoa;

public class ObjectionToJsonTester {

    public static void main(String[] args) {
        Pessoa pessoa  = new Pessoa(1, "João", "12345678910");
        ObjectToJson object = new ObjectToJson();

        ;
        System.out.println(object.transform(pessoa));
    }
}
