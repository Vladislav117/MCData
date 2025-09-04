package ru.vladislav117.mcdata.error;

import org.bukkit.persistence.PersistentDataType;

/**
 * Ошибка, возникающая при несовпадении типов значений.
 */
public class DataManagerTypeError extends DataManagerError {
    /**
     * Создание ошибки, возникающей при несовпадении типов значений.
     *
     * @param type Неверный тип значения
     */
    public DataManagerTypeError(PersistentDataType<?, ?> type) {
        super("Type is not \"" + type + "\"");
    }
}
