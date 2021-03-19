/* Escreva uma classe em java que simule uma calculadora bem simples.
Essa classe deve ter como atributos duas variáveis double e um char.
Deve possuir um construtor que recebe como parâmetros dois números e um caractere, correspondente a uma das operações básicas (+,-,*,/).
Deve ter um método para calcular a operação desejada e um para imprimir o resultado.
O programa deve considerar divisões por zero como sendo erros, e imprimir uma mensagem adequada. */

import java.util.*;

class Main {
  public static void main(String[] args) throws customException {
    
		double n1, n2;
		char op;
	
		op = escolheOpcao();
		n1 = getNumero();
		n2 = getNumero();

		System.out.println(Calculadora.fazCalculo(n1, n2, op));

  }

	public static char escolheOpcao() {
		Scanner sc = new Scanner(System.in);
		char o='+';
		try {
			System.out.print("\n\n*** Escolha uma opção ***\n    '*' para Multiplicação de inteiros\n    '/' para Divisão de inteiros\n    '+' para Adição de inteiros\n    '-' para Subtração de inteiros\n\n>> ");
			o = sc.next().charAt(0);
		} catch (InputMismatchException erro1) {
			System.out.println("Digite uma opção válida!");
			sc.nextLine();
		}
		return o;
	}

	public static double getNumero() {
		Scanner sc = new Scanner(System.in);
		double n=0;
		try {
			System.out.print("Informe um número inteiro >> ");
			n = sc.nextDouble();
		} catch (InputMismatchException erro1) {
			System.out.println("Digite um número inteiro!");
			sc.nextLine();
		}
		return n;
	}
	
}

class Calculadora {

	double n1, n2;
	char operacao;

	public Calculadora(double x1, double x2, char op) {
		n1 = x1;
		n2 = x2;
		operacao = op;
		//fazCalculo(n1, n2, operacao);
	}

	public static double fazCalculo(double x, double y, char o) throws customException {
		double resultado=0;
		
		if (o == '+') {
			resultado = x+y;
		} else if (o == '-') {
			resultado = x-y;
		} else if (o == '*') {
			resultado = x*y;
		} else if (o == '/') {
			if (y != 0) {
				resultado = (x/y);
			} else {
				throw new customException("Erro! Divisão por Zero.");
			}
		}

		return resultado;	
	}

}

class customException extends Exception {
  public customException(String m) {
    super(m);
  }
}