import java.time.LocalDate;
public class TvContract extends Contract{
    private String packageChannels;

    public TvContract(int id, LocalDate startDate, LocalDate endDate, String number, Person owner, String packageChannels)
    {
        super(id, startDate, endDate, number, owner);
        this.packageChannels = packageChannels;
    }

    public String getPackageChannels()
    {
        return packageChannels;
    }

    public void setPackageChannels(String packageChannels) {
        this.packageChannels = packageChannels;
    }

    @Override
    public String toString() {
        return "DigitalTvContract{" +
                "id=" + getId() +
                ", startDate=" + getStartDate() +
                ", endDate=" + getEndDate() +
                ", number='" + getContractNumber() + '\'' +
                ", owner=" + getPerson() +
                ", packageChannels='" + packageChannels + '\'' +
                '}';
    }
}
