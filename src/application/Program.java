package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Lesson> list = new ArrayList<>();
		
		System.out.print("Quantas aulas tem o curso? ");
		int N = sc.nextInt();
		
		for (int i=0; i<N; i++) {
			System.out.println();
			System.out.printf("Dados da %da aula:\n", (i+1));
			System.out.print("Conteudo ou tarefa (c/t)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Titulo: ");
			sc.nextLine();
			String title = sc.nextLine();
			if (ch == 'c') {
				System.out.print("URL do video: ");
				String url = sc.nextLine();
				System.out.print("Duracao em segundos: ");
				int seconds = sc.nextInt();
				
				Lesson video = new Video(title, url, seconds);
				list.add(video);
			}
			else {
				System.out.print("Descricao: ");
				String description = sc.nextLine();
				System.out.print("Quantidade de questoes: ");
				int questionCount = sc.nextInt();
				
				Lesson task = new Task(title, description, questionCount);
				list.add(task);
			}
		}
		
		System.out.println();
		int sum = 0;
		for (Lesson l : list) {
			sum += l.duration();
		}
		System.out.println("DURACAO TOTAL DO CURSO = " + sum + " segundos" );
		
		
		sc.close();

	}

}
