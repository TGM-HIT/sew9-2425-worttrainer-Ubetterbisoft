public interface PersistanceStrategy {
    boolean save(WordTrainer wordTrainer);
    WordTrainer load();
}
