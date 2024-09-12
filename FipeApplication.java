package br.edu.fatec.fipe.view;

import br.edu.fatec.fipe.model.Fipe;
import br.edu.fatec.fipe.service.ConsomeApi;
import br.edu.fatec.fipe.service.ConverteDado;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class FipeApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FipeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
        Scanner scan = new Scanner(System.in);

        int i = 1;
        while (i == 1) {

            ConverteDado conversor = new ConverteDado();
            String json = ConsomeApi.printarMarca();
            System.out.println(json);

            System.out.println("Digite o código da marca do Carro:");
            String marca = scan.nextLine();

            String json1 = ConsomeApi.printarModelo(marca);
            System.out.println(json1);

            System.out.println("Digite o código do modelo do Carro:");
            String modelo = scan.nextLine();

            String json2 = ConsomeApi.printarAno(marca, modelo);
            System.out.println(json2);


            System.out.println("Digite o ano do Carro:");
            String ano = scan.nextLine();

            String json3 = ConsomeApi.obterDados(marca, modelo, ano);
            Fipe jsonTratado = conversor.obterDado(json3, Fipe.class);
            System.out.println(jsonTratado);

            System.out.println("\n\nDigite 1 para fazer uma nova consulta e 2 para fechar o programa:");
            i = scan.nextInt();
			scan.nextLine();
            if (i != 1) {
                break;
            }


        }
    }
}
