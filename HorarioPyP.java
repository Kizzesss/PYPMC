import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HorarioPyP {

	private int id;
	private String descripcion;
	private Calendar horaDesde;
	private Calendar horaHasta;

	public HorarioPyP() {
		super();
	}

	public HorarioPyP(int id, String descripcion, Calendar horaDesde, Calendar horaHasta) {
		this.id = id;
		this.descripcion = descripcion;
		this.horaDesde = horaDesde;
		this.horaHasta = horaHasta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Calendar getHoraDesde() {
		return horaDesde;
	}

	public void setHoraDesde(Calendar horaDesde) {
		this.horaDesde = horaDesde;
	}

	public Calendar getHoraHasta() {
		return horaHasta;
	}

	public void setHoraHasta(Calendar horaHasta) {
		this.horaHasta = horaHasta;
	}

	public boolean estaEnHoraPico(HorarioPyP horario, Calendar hora) {

		Calendar horarioDesde = Calendar.getInstance();
               
		horarioDesde.setTime(hora.getTime());
		horarioDesde.set(Calendar.HOUR_OF_DAY, horario.getHoraDesde().get(Calendar.HOUR_OF_DAY));
		horarioDesde.set(Calendar.MINUTE, horario.getHoraDesde().get(Calendar.MINUTE));
		horarioDesde.set(Calendar.SECOND, 0);
		horarioDesde.set(Calendar.MILLISECOND, 0);

		Calendar horarioHasta = Calendar.getInstance();
		horarioHasta.setTime(hora.getTime());
		horarioHasta.set(Calendar.HOUR_OF_DAY, horario.getHoraHasta().get(Calendar.HOUR_OF_DAY));
		horarioHasta.set(Calendar.MINUTE, horario.getHoraHasta().get(Calendar.MINUTE));
		horarioHasta.set(Calendar.SECOND, 0);
		horarioHasta.set(Calendar.MILLISECOND, 0);

		SimpleDateFormat formato = new SimpleDateFormat("HH:mm");

		System.out.println("No se puede desde las " + formato.format(horarioDesde.getTime()) + " hasta las "
				+ formato.format(horarioHasta.getTime()) + " Su hora ingresada fue" + formato.format(hora.getTime()));

		return (hora.compareTo(horarioDesde) >= 0 && hora.compareTo(horarioHasta) <= 0);
	}

	public HorarioPyP getHorarioNocturno() {
		Calendar horaDesde = Calendar.getInstance();
		horaDesde.set(Calendar.HOUR_OF_DAY, 16);
		horaDesde.set(Calendar.MINUTE, 0);
		horaDesde.set(Calendar.SECOND, 0);

		Calendar horaHasta = Calendar.getInstance();
		horaHasta.set(Calendar.HOUR_OF_DAY, 19);
		horaHasta.set(Calendar.MINUTE, 30);
		horaHasta.set(Calendar.SECOND, 0);

		return new HorarioPyP(1, "De 16:00 a 19:30", horaDesde, horaHasta);
	}

	public HorarioPyP getHorarioDiurno() {
		Calendar horaDesde = Calendar.getInstance();
		horaDesde.set(Calendar.HOUR_OF_DAY, 7);
		horaDesde.set(Calendar.MINUTE, 0);
		horaDesde.set(Calendar.SECOND, 0);

		Calendar horaHasta = Calendar.getInstance();
		horaHasta.set(Calendar.HOUR_OF_DAY, 9);
		horaHasta.set(Calendar.MINUTE, 30);
		horaHasta.set(Calendar.SECOND, 0);

		return new HorarioPyP(2, "De 7:00 a 9:30", horaDesde, horaHasta);
	}

}
