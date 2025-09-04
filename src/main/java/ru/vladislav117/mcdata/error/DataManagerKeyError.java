package ru.vladislav117.mcdata.error;

import org.bukkit.NamespacedKey;

/**
 * Ошибка, возникающая при отсутствии ключа в контейнере.
 */
public class DataManagerKeyError extends DataManagerError {
    /**
     * Создание ошибки, возникающей при отсутствии ключа в контейнере.
     *
     * @param key Ключ
     */
    public DataManagerKeyError(NamespacedKey key) {
        super("Key \"" + key + "\" does not exists");
    }
}
