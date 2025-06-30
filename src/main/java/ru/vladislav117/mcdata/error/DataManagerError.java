package ru.vladislav117.mcdata.error;

/**
 * Ошибка, связанная с менеджером данных.
 */
public class DataManagerError extends Error {
    /**
     * Создание ошибки, связанной с менеджером данных.
     *
     * @param message Сообщение об ошибке
     */
    public DataManagerError(String message) {
        super(message);
    }
}
