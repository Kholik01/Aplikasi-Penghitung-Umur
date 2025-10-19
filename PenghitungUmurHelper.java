import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.TextStyle;
import java.util.Locale;

public class PenghitungUmurHelper {

    // Hitung umur detail dalam format: "x tahun, y bulan, z hari"
    public String hitungUmurDetail(LocalDate lahir, LocalDate sekarang) {
        if (lahir == null || sekarang == null) {
            return "-";
        }

        Period p = Period.between(lahir, sekarang);
        return p.getYears() + " tahun, " + p.getMonths() + " bulan, " + p.getDays() + " hari";
    }

    // Hitung tanggal ulang tahun berikutnya
    public LocalDate hariUlangTahunBerikutnya(LocalDate lahir, LocalDate sekarang) {
        LocalDate ulangTahun = lahir.withYear(sekarang.getYear());
        if (!ulangTahun.isAfter(sekarang)) {
            ulangTahun = ulangTahun.plusYears(1);
        }
        return ulangTahun;
    }

    // Dapatkan nama hari (Senin, Selasa, dst) dalam Bahasa Indonesia
    public String getDayOfWeekInIndonesian(LocalDate date) {
        if (date == null) return "-";
        DayOfWeek day = date.getDayOfWeek();

        String hari = switch (day) {
            case MONDAY -> "Senin";
            case TUESDAY -> "Selasa";
            case WEDNESDAY -> "Rabu";
            case THURSDAY -> "Kamis";
            case FRIDAY -> "Jumat";
            case SATURDAY -> "Sabtu";
            case SUNDAY -> "Minggu";
        };

        return hari;
    }
}
