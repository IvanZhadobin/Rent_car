package entity;

public class Mark {
    private final Long id;
    private String markName;

    public Mark(Long id, String markName) {
        this.id = id;
        this.markName = markName;
    }

    public Long getId() {
        return id;
    }

    public String getMarkName() {
        return markName;
    }

    public void setMarkName(String markName) {
        this.markName = markName;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "id=" + id +
                ", markName='" + markName + '\'' +
                '}';
    }
}
