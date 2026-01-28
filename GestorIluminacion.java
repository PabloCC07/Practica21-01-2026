/**
 * @author Pablo Cuadrado
 */
public class GestorIluminacion {

    /**
     * boolean que dice si las luces están encendidas o apagadas
     */
    private boolean[] iluminacion;

    /**
     * crea el gestor de iluminación con un número máximo de pistas
     * @param maxPistas numero maximo de pistas
     */
    public GestorIluminacion(int maxPistas) {
        iluminacion = new boolean[maxPistas];
    }

    /**
     * enciende las luces de la pista validando que la pista existe
     * @param idPista id de la pista
     * @return devuelve true o false dependiendo de si la pista existe o no existe
     */
    public boolean encenderLuces(int idPista) {
        if (idPista < 0 || idPista >= iluminacion.length) {
            return false; // ID de pista inválido
        }
        iluminacion[idPista] = true;
        return true;
    }

    /**
     * apaga las luces de la pista validando que la pista existe
     * @param idPista id de la pista
     * @return devuelve false si el id no existe o true si existe y se apaga
     */
    public boolean apagarLuces(int idPista) {
        if (idPista < 0 || idPista >= iluminacion.length) {
            return false; // ID de pista inválido
        }
        iluminacion[idPista] = false;
        return true;
    }
}
