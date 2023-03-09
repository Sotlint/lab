import java.time.LocalDate;
public class InternetContract extends Contract{
    private int speed;

    public InternetContract(int id, LocalDate startDate, LocalDate endDate, String number, Person owner, int speed)
    {
        super(id, startDate, endDate, number, owner);
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "WiredInternetContract{" +
                "id=" + getId() +
                ", startDate=" + getStartDate() +
                ", endDate=" + getEndDate() +
                ", number='" + getContractNumber() + '\'' +
                ", owner=" + getPerson() +
                ", speed=" + speed +
                '}';
    }
}
