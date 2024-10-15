public interface PersistanceStrategy {
    void save(WordTrainer wordTrainer);
    void load();
}
