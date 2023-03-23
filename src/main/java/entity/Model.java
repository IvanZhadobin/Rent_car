package entity;

public class Model {
    private final Long id;
    private final Long markId;
    private String modelName;

    public Model(Long id, Long markId, String modelName) {
        this.id = id;
        this.markId = markId;
        this.modelName = modelName;
    }

    public Long getId() {
        return id;
    }

    public Long getMarkId() {
        return markId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", markId=" + markId +
                ", modelName='" + modelName + '\'' +
                '}';
    }
}
