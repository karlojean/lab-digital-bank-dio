import java.time.LocalDate;

public class Movimentation {
    private Type movimantationType;

    private double value;

    private LocalDate date;

    public Movimentation(Type movimantationType, double value, LocalDate date) {
        this.movimantationType = movimantationType;
        this.value = value;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Movimentation{" +
                "movimantationType=" + movimantationType +
                ", value=" + value +
                ", date=" + date +
                '}';
    }
}
