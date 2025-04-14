package Utils;
/**
 *
 * @author nyath
 */
import java.time.LocalTime;
import java.time.Duration;

public class TimeUtils {
    public static LocalTime calcHoraFinalizacion(LocalTime hora_inicial, LocalTime duracion){
        //convertir la hora a sumar en Duration
        Duration tiempo_sum = Duration.ofHours(duracion.getHour()).plusMinutes(duracion.getMinute());
        //retornar la suma de Duration a la hora inicial
        return hora_inicial.plus(tiempo_sum);
    }
}
