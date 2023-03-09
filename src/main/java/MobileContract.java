import java.time.LocalDate;
public class MobileContract extends Contract
{
    private int minutes;
    private int sms;
    private int gb;

    public MobileContract(int id, LocalDate startDate, LocalDate endDate, String number, Person owner, int minutes, int sms, int gb)
    {
        super(id, startDate, endDate, number, owner);
        this.minutes = minutes;
        this.sms = sms;
        this.gb = gb;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSms() {
        return sms;
    }

    public void setSms(int sms) {
        this.sms = sms;
    }

    public int getGb() {
        return gb;
    }

    public void setGb(int gb) {
        this.gb = gb;
    }

    @Override
    public String toString() {
        return "MobileContract{" +
                "id=" + getId() +
                ", startDate=" + getStartDate() +
                ", endDate=" + getEndDate() +
                ", number='" + getContractNumber() + '\'' +
                ", owner=" + getPerson() +
                ", minutes=" + minutes +
                ", sms=" + sms +
                ", gb=" + gb +
                '}';
    }
}
