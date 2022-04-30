import java.sql.Date;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class TimeApplication {

    public static void main(String[] args) {

        //Java Time

        // Representação de horário
        //LocalTime;

        // Representação de data
        // Padrão ISO 8601: yyyy-MM-dd
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String dataFormatada = localDate.format(formatter);

        System.out.println(dataFormatada);

        //2022-04-28
        System.out.println(LocalDate.of(2022, 04, 28));
        System.out.println(LocalDate.parse("2022-04-28"));
        //System.out.println(LocalDate.parse("2022/04/28"));

        // Formatar a apresentação de data e hora
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.format(formatterTime));

        System.out.println("Diferença: " + ChronoUnit.DAYS.between(LocalDate.parse("2022-01-28"),localDate));

        //Sobre o erro que deu durante a quinta-feira na conversão com timezone:
        //O LocalDateTime não possui informações sobre timezone, por isso acontecia o erro "Unable to extract ZoneId from temporal"
        //Para termos a informação de TimeZone, precisamos usar o "ZonedDateTime" (a implementação é igualzinha)

        //DateTimeFormatter formatterTimeWithZone = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss, Z"); //30/04/2022 15:28:22, -0300
        //DateTimeFormatter formatterTimeWithZone = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss, z"); //30/04/2022 15:28:22, BRT
        DateTimeFormatter formatterTimeWithZone = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss, zzzz"); //30/04/2022 15:28:22, Brasilia Standard Time
        ZonedDateTime zonedDate = ZonedDateTime.now();
        System.out.println(zonedDate.format(formatterTimeWithZone));


        ZoneId zoneId = ZoneId.of("Europe/Paris");
        ZonedDateTime dataParis = ZonedDateTime.of(localDateTime, zoneId);

        System.out.println(dataParis);
    }
}
