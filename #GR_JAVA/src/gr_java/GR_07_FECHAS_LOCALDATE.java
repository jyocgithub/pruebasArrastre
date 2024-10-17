package gr_java;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class GR_07_FECHAS_LOCALDATE {
    public static void main(String[] args) {



        // LOCALDATE







        LocalDate fecha1 = LocalDate.of(2020, 5, 15);
        LocalDate fecha2 = LocalDate.now();

        // ver cual de las dos es mayor
        if (fecha1.isBefore(fecha2)) {
            System.out.println("La fecha mayor es la fecha 2");
        } else {
            System.out.println("La fecha mayor es la fecha 1");
        }

        // mostrar los dias y los meses de diferencia entre ambas fechas
        long diasdediferencia = ChronoUnit.DAYS.between(fecha1, fecha2);
        long mesesdediferencia = ChronoUnit.MONTHS.between(fecha1, fecha2);
        System.out.println(diasdediferencia);

        // sumar 2 meses y 3 dias a la fecha2 y mostrar la fecha resultantes
        fecha2 = fecha2.plusMonths(2);
        fecha2 = fecha2.plusDays(3);

        System.out.println("La fecha 2 ahora es " + fecha2.toString());

        // mostrarlo en castellano
        String formatoCastellano = localdateToString(fecha2);
        System.out.println(formatoCastellano);

    }

    public static LocalDate stringToLocaldate(String fechaEnString) {
        if (fechaEnString == null) {
            return null;
        }
        return LocalDate.parse(fechaEnString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public static String localdateToString(LocalDate fechaEnlocaldate) {
        if (fechaEnlocaldate == null) {
            return null;
        }
        return fechaEnlocaldate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public static Date localDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }


    public static LocalDate dateToLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }


}
