import java.time.LocalDate;

public class Reserva {

    /**
     * guarda el id de la pista que se reserva
     */
    private int idPista;

    /**
     * guarda la fecha de la reserva
     */
    private LocalDate fecha;

    /**
     * guarda la duracion de la reserva
     */
    private int duracion;

    /**
     * crea una reserva usando el id de la pista, la fecha
     * de la reserva y su duracion
     * @param idPista id de la pista
     * @param fecha fecha de la reserva
     * @param duracion duracion de la reserva
     */
    public Reserva(int idPista, LocalDate fecha, int duracion) {
        this.idPista = idPista;
        this.fecha = fecha;
        this.duracion = duracion;
    }

    /**
     * devuelve el valor de idPista para poder consultarlo
     * desde fuera de la clase
     * @return devuelve el valor de idPista
     */
    public int getIdPista() {
        return idPista;
    }

    /**
     * devuelve el valor de la fecha de la reserva
     * @return devuelve la fecha de la reserva
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * devuelve la duración de la reserva en minutos u horas
     * @return devuelve la duracion de la reserva
     */
    public int getDuracion() {
        return duracion;
    }
}