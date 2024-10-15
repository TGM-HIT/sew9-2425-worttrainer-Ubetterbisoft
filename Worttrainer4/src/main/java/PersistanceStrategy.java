public interface PersistanceStrategy {
    void save(WordTrainer wordTrainer);
    WordTrainer load();
}
