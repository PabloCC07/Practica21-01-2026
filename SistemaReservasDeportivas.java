import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaReservasDeportivas {

    /**
     * guarda las reservas realizadas
     */
    private List<Reserva> reservas;

    /**
     * boolean que dice si las luces están encendidas o apagadas
     */
    private boolean[] iluminacion;

    /**
     * el número máximo de pistas que puede manejar el sistema
     */
    private static final int MAX_PISTAS = 10; // Asumimos un máximo de 10 pistas

    /**
     * lista vacia donde se guardaran las reservas
     */
    public SistemaReservasDeportivas() {
        reservas = new ArrayList<>();
        iluminacion = new boolean[MAX_PISTAS];
    }

    /**
     * reservar una pista, si hay hueco devolverá true y
     * añade una nueva reserva a la lista, si
     * no hay espacio devolverá false
     * @param reserva guarda las reservas realizadas
     * @return devuelve true si se puede realizar una reserva
     * y false si no es posible hacer la reserva
     */
    public boolean reservarPista(Reserva reserva) {
        if (reserva.getIdPista() < 0 || reserva.getIdPista() >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        for (Reserva r : reservas) {
            if (esFechaDisponible(reserva.getIdPista(), reserva.getFecha(), r)) return false; // La pista ya está reservada en esa fecha
        }
        reservas.add(new Reserva(reserva.getIdPista(), reserva.getFecha(), reserva.getDuracion()));
        return true;
    }

    /**
     * comprueba si una reserva coincide con la misma pista
     * o la misma fecha
     * @param idPista pista reservada
     * @param fecha hora de la reserva
     * @param r reserva
     * @return devuelve true si la pista ya esta reservada
     * y false si la pista esta disponibe
     */
    private static boolean esFechaDisponible(int idPista, LocalDate fecha, Reserva r) {
        if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {
            return true;
        }
        return false;
    }

    /**
     * recorre la lista reservas y si encuetra una la pista que
     * quieres eliminar devuelve true y la elimina, mientras que
     * si no encuentra la pista devuelve false
     * @param idReserva id de la reserva de la pista
     * @return devuelve true o false en función de si hay una
     * pista que poder eliminar o no la hay
     */
    public boolean cancelarReserva(int idReserva) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getIdPista() == idReserva) {
                reservas.remove(i);
                return true;
            }
        }
        return false; // No se encontró la reserva
    }

    /**
     * enciende las luces de la pista validando que la pista
     * existe
     * @param idPista id de la pista
     * @return devuelve true o false dependiendo de si la pista
     * existe o si no existe
     */
    public boolean encenderLuces(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        iluminacion[idPista] = true;
        return true;
    }

    /**
     * apaga las luces de la pista validando que la pista
     * existe
     * @param idPista id de la pista
     * @return devuelve false para apagar las luces si el
     * id existe o true si el id no existe
     */
    public boolean apagarLuces(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        iluminacion[idPista] = false;
        return true;
    }

    /**
     * comprueba si una pista esta libre en una fecha en
     * especifico
     * @param idPista id de la pista
     * @param fecha dia de al reserva
     * @param hora hora de la reserva
     * @return devuelve false si existe una reserva para el id
     * de esa pista o true si está disponible para reservar
     */
    public boolean verificarDisponibilidad(int idPista, LocalDate fecha, String hora) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        for (Reserva r : reservas) {
            if (compararFechas(idPista, fecha, r)) return false; // La pista no está disponible en esa fecha
        }
        return true; // La pista está disponible
    }

    /**
     * compara la fecha de la reserva de una pista con la fecha
     * de la cual estamos buscando su disponibilidad
     * @param idPista id de la pista
     * @param fecha fecha de la reserva
     * @param r variable que almacena las reservas
     * @return devuelve true si la reserva r coincide en pista
     * y fecha y false si no coincide
     */
    private static boolean compararFechas(int idPista, LocalDate fecha, Reserva r) {
        if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {
            return true;
        }
        return false;
    }
}