import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class PlacaPermitida {

	private String placa;
	private String fecha;
	private String hora;
	private boolean permitido;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public boolean isPermitido() {
		return permitido;
	}

	public void setPermitido(boolean permitido) {
		this.permitido = permitido;
	}

	public String ultimoDigitoPlaca() {
		if (placa == null || placa.isEmpty()) {
			return null;
		}
		final int tamanio = placa.length();
		return placa.substring(tamanio - 1, tamanio);
	}

	public Calendar getFechaHora() {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		Calendar fechaCal = null;
		try {
			format.parse(fecha + " " + hora);
			fechaCal = Calendar.getInstance();
			fechaCal.setTime(format.parse(fecha + " " + hora));
		} catch (ParseException ex) {
			Logger.getLogger(PlacaPermitida.class.getName()).log(Level.SEVERE, null, ex);
		}
		return fechaCal;
	}

	public int getDiaSemana() {
		return getFechaHora().get(Calendar.DAY_OF_WEEK);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Datos: Placa: " + placa);	
		builder.append(", Fecha: " + fecha);
		builder.append(", Hora: " + hora);

		return builder.toString();
	}

	public String mostrarResultadoFinal() {
		StringBuilder builder = new StringBuilder();
		builder.append("Datos: Placa: " + placa);	
		builder.append(", Fecha: " + fecha);
		builder.append(", Hora: " + hora);
		
		JOptionPane.showMessageDialog(null, "Le diremos si puede circular: ");
		JOptionPane.showMessageDialog(null, permitido ? "Si puede" : "No puede");
		
		return builder.toString();
	}

}