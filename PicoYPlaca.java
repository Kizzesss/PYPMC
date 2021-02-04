import java.util.Calendar;

public class PicoYPlaca {

	private int id;
	private Dias diaEnum;
	private HorarioPyP horario;
	private String ultimoDigito;

	public PicoYPlaca(int id, Dias diaEnum, HorarioPyP horario, String ultimoDigito) {
		this.id = id;
		this.diaEnum = diaEnum;
		this.horario = horario;
		this.ultimoDigito = ultimoDigito;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Dias getDiaEnum() {
		return diaEnum;
	}

	public void setDiaEnum(Dias diaEnum) {
		this.diaEnum = diaEnum;
	}

	public HorarioPyP getHorario() {
		return horario;
	}

	public void setHorario(HorarioPyP horario) {
		this.horario = horario;
	}

	public String getUltimoDigito() {
		return ultimoDigito;
	}

	public void setUltimoDigito(String ultimoDigito) {
		this.ultimoDigito = ultimoDigito;
	}

	@Override
	public String toString() {
		return "Dia: " + diaEnum.getNombreDia() + ", horario: " + horario.getDescripcion()
				+ ", y su placa termina en: " + ultimoDigito;
	}

	public PicoYPlaca estaEnPicoYPlaca(int dia, Calendar hora, String ultimoDigito) {
		if (dia == this.getDiaEnum().getNumeroDia() && this.getUltimoDigito().equals(ultimoDigito)
				&& this.getHorario().estaEnHoraPico(this.getHorario(), hora)) {
			return this;
		}
		return null;
	}

}
