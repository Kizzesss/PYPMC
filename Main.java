import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class Main {

	public void verificarPicoYPlaca(PlacaPermitida predictor) {
		System.out.println("\n" + predictor.toString());
		System.out.println("Dia de la fecha ingresada: "
				+ predictor.getFechaHora().getDisplayName(Calendar.DAY_OF_WEEK, 2, new Locale("es")) + "(Numero de dia "
				+ predictor.getFechaHora().get(Calendar.DAY_OF_WEEK) + ")");
		System.out.println("Hora ingresada: " + predictor.getFechaHora().get(Calendar.HOUR_OF_DAY) + ":"
				+ predictor.getFechaHora().get(Calendar.MINUTE)+"0");

		System.out.println("\nPara su Placa: " + predictor.getPlaca() + " su ultimo digito es = "
				+ predictor.ultimoDigitoPlaca());
		PicoYPlaca picoPlacaValidacion = validarPicoYPlaca(predictor);
		System.out.println("\nPico y Placa " + predictor.mostrarResultadoFinal());
		if (picoPlacaValidacion != null) {
			System.out.println("\nNo olvide que el horarios es: " + picoPlacaValidacion.toString());
		}

	}

	private PicoYPlaca validarPicoYPlaca(PlacaPermitida predictor) {
		PicoYPlaca picoPlacaValidacion = null;
		for (PicoYPlaca picoPlaca : configuracionHorariosPicoYPlaca()) {
			picoPlacaValidacion = picoPlaca.estaEnPicoYPlaca(predictor.getDiaSemana(), predictor.getFechaHora(),
					predictor.ultimoDigitoPlaca());
			if (picoPlacaValidacion == null) {
				predictor.setPermitido(Boolean.TRUE);
			} else {
				predictor.setPermitido(Boolean.FALSE);
				break;
			}
		}
		return picoPlacaValidacion;
	}

	private static List<PicoYPlaca> configuracionHorariosPicoYPlaca() {
		HorarioPyP horario = new HorarioPyP();
		List<PicoYPlaca> listaPicoPlaca = new ArrayList<>();
		listaPicoPlaca.add(new PicoYPlaca(1, Dias.LUN, horario.getHorarioDiurno(), "1"));
		listaPicoPlaca.add(new PicoYPlaca(2, Dias.LUN, horario.getHorarioNocturno(), "1"));
		listaPicoPlaca.add(new PicoYPlaca(3, Dias.LUN, horario.getHorarioDiurno(), "2"));
		listaPicoPlaca.add(new PicoYPlaca(4, Dias.LUN, horario.getHorarioNocturno(), "2"));

		listaPicoPlaca.add(new PicoYPlaca(5, Dias.MAR, horario.getHorarioDiurno(), "3"));
		listaPicoPlaca.add(new PicoYPlaca(6, Dias.MAR, horario.getHorarioNocturno(), "3"));
		listaPicoPlaca.add(new PicoYPlaca(7, Dias.MAR, horario.getHorarioDiurno(), "4"));
		listaPicoPlaca.add(new PicoYPlaca(8, Dias.MAR, horario.getHorarioNocturno(), "4"));

		listaPicoPlaca.add(new PicoYPlaca(9, Dias.MIE, horario.getHorarioDiurno(), "5"));
		listaPicoPlaca.add(new PicoYPlaca(10, Dias.MIE, horario.getHorarioNocturno(), "5"));
		listaPicoPlaca.add(new PicoYPlaca(11, Dias.MIE, horario.getHorarioDiurno(), "6"));
		listaPicoPlaca.add(new PicoYPlaca(12, Dias.MIE, horario.getHorarioNocturno(), "6"));

		listaPicoPlaca.add(new PicoYPlaca(13, Dias.JUE, horario.getHorarioDiurno(), "7"));
		listaPicoPlaca.add(new PicoYPlaca(14, Dias.JUE, horario.getHorarioNocturno(), "7"));
		listaPicoPlaca.add(new PicoYPlaca(15, Dias.JUE, horario.getHorarioDiurno(), "8"));
		listaPicoPlaca.add(new PicoYPlaca(16, Dias.JUE, horario.getHorarioNocturno(), "8"));

		listaPicoPlaca.add(new PicoYPlaca(17, Dias.VIE, horario.getHorarioDiurno(), "9"));
		listaPicoPlaca.add(new PicoYPlaca(18, Dias.VIE, horario.getHorarioNocturno(), "9"));
		listaPicoPlaca.add(new PicoYPlaca(19, Dias.VIE, horario.getHorarioDiurno(), "0"));
		listaPicoPlaca.add(new PicoYPlaca(20, Dias.VIE, horario.getHorarioNocturno(), "0"));

		return listaPicoPlaca;
	}

	public static void main(String[] args) {

		String placa;
		String fecha;
		String hora;

		Scanner sc = new Scanner(System.in);

		JOptionPane.showMessageDialog(null, new JLabel("Bienvenido Pico y Placa: Ingrese sus datos", JLabel.CENTER));
        
		placa = JOptionPane.showInputDialog("Numero de Placa (Ejm. ABC-1234): ");     	
        while(placa.length() > 8 || placa.length() < 7){			
			placa = JOptionPane.showInputDialog("Placa mal ingresada intentelo de nuevo por favor");  			
		}

		fecha = JOptionPane.showInputDialog("Fecha que va a circular (dd-mm-aaaa Ejm. 01-01-2021): ");     	
        while(fecha.length() > 10 || fecha.length() < 6){			
			fecha = JOptionPane.showInputDialog("Fecha mal ingresada intentelo de nuevo por favor");  			
		}
        
		hora = JOptionPane.showInputDialog("Hora que va a circular (HH:mm Ejm. 12:00): ");     	
        while(hora.length() > 5 || hora.length() < 4){			
			hora = JOptionPane.showInputDialog("Horario mal ingresada intentelo de nuevo por favor");  			
		}
		
		PlacaPermitida predictor = new PlacaPermitida();

		predictor.setPlaca(placa);
		predictor.setFecha(fecha);
		predictor.setHora(hora);
		
		Main app = new Main();
		app.verificarPicoYPlaca(predictor);

	}

}