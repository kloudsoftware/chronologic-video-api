package video.chronologic.api.util.youtubeDTO;

public class Thumbnails {
    private Default _default;

    private Standard standard;

    private High high;

    private Maxres maxres;

    private Medium medium;

    public Default getDefault() {
        return _default;
    }


    public void setDefault(Default _default) {
        this._default = _default;
    }

    public Standard getStandard() {
        return standard;
    }

    public void setStandard(Standard standard) {
        this.standard = standard;
    }

    public High getHigh() {
        return high;
    }

    public void setHigh(High high) {
        this.high = high;
    }

    public Maxres getMaxres() {
        return maxres;
    }

    public void setMaxres(Maxres maxres) {
        this.maxres = maxres;
    }

    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

}
