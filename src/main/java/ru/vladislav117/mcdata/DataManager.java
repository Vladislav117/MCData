package ru.vladislav117.mcdata;

import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.Nullable;
import ru.vladislav117.mcdata.error.DataManagerKeyError;
import ru.vladislav117.mcdata.error.DataManagerTypeError;

/**
 * Менеджер данных для PersistentDataContainer.
 */
public class DataManager {
    static String defaultNamespace = "minecraft";
    protected String namespace;
    protected PersistentDataContainer container;

    /**
     * Создание менеджера данных.
     *
     * @param container Контейнер
     * @param namespace Пространство имён
     */
    public DataManager(PersistentDataContainer container, String namespace) {
        this.container = container;
        this.namespace = namespace;
    }

    /**
     * Создание менеджера данных.
     *
     * @param container Контейнер
     */
    public DataManager(PersistentDataContainer container) {
        this.container = container;
        this.namespace = defaultNamespace;
    }

    /**
     * Получение пространства имён по умолчанию.
     *
     * @return Пространство имён по умолчанию.
     */
    public static String getDefaultNamespace() {
        return defaultNamespace;
    }

    /**
     * Установка пространства имён по умолчанию.
     *
     * @param defaultNamespace Пространство имён по умолчанию
     */
    public static void setDefaultNamespace(String defaultNamespace) {
        DataManager.defaultNamespace = defaultNamespace;
    }

    /**
     * Проверка наличия ключа.
     *
     * @param key Ключ
     * @return Наличие ключа.
     */
    public boolean contains(NamespacedKey key) {
        return container.has(key);
    }

    /**
     * Проверка наличия ключа.
     *
     * @param keyString Ключ
     * @return Наличие ключа.
     */
    public boolean contains(String keyString) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        return container.has(key);
    }

    /**
     * Проверка значения по ключу на тип Byte.
     * Если значения по ключу нет, будет возвращено false.
     *
     * @param key Ключ
     * @return Является ли значение по ключу Byte.
     */
    public boolean isByte(NamespacedKey key) {
        return container.has(key, PersistentDataType.BYTE);
    }

    /**
     * Получение Byte значения по ключу.
     * Если в контейнере нет указанного ключа, будет вызвано исключение.
     * Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     *
     * @param key Ключ
     * @return Значение по ключу.
     * @throws DataManagerKeyError Если в контейнере нет указанного ключа, будет вызвано исключение.
     * @throws DataManagerTypeError Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     */
    public byte getByte(NamespacedKey key) {
        if (!container.has(key)) throw new DataManagerKeyError(key);
        if (!container.has(key, PersistentDataType.BYTE)) throw new DataManagerTypeError(PersistentDataType.BYTE);
        return container.get(key, PersistentDataType.BYTE);
    }

    /**
     * Получение Byte значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено null.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено null.
     *
     * @param key Ключ
     * @return Значение по ключу или null.
     */
    public @Nullable Byte getByteOrNull(NamespacedKey key) {
        if (!container.has(key)) return null;
        if (!container.has(key, PersistentDataType.BYTE)) return null;
        return container.get(key, PersistentDataType.BYTE);
    }

    /**
     * Получение Byte значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено значение по умолчанию.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено значение по умолчанию.
     *
     * @param key Ключ
     * @param defaultValue Значение по умолчанию
     * @return Значение по ключу или значение по умолчанию.
     */
    public Byte getByteOrDefault(NamespacedKey key, Byte defaultValue) {
        if (!container.has(key)) return defaultValue;
        if (!container.has(key, PersistentDataType.BYTE)) return defaultValue;
        return container.get(key, PersistentDataType.BYTE);
    }

    /**
     * Установка Byte значения по ключу.
     *
     * @param key Ключ
     * @param value Значение
     * @return Этот же менеджер.
     */
    public DataManager setByte(NamespacedKey key, byte value) {
        container.set(key, PersistentDataType.BYTE, value);
        return this;
    }

    /**
     * Проверка значения по ключу на тип Byte.
     * Если значения по ключу нет, будет возвращено false.
     *
     * @param keyString Ключ
     * @return Является ли значение по ключу Byte.
     */
    public boolean isByte(String keyString) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        return container.has(key, PersistentDataType.BYTE);
    }

    /**
     * Получение Byte значения по ключу.
     * Если в контейнере нет указанного ключа, будет вызвано исключение.
     * Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     *
     * @param keyString Ключ
     * @return Значение по ключу.
     * @throws DataManagerKeyError Если в контейнере нет указанного ключа, будет вызвано исключение.
     * @throws DataManagerTypeError Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     */
    public byte getByte(String keyString) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        if (!container.has(key)) throw new DataManagerKeyError(key);
        if (!container.has(key, PersistentDataType.BYTE)) throw new DataManagerTypeError(PersistentDataType.BYTE);
        return container.get(key, PersistentDataType.BYTE);
    }

    /**
     * Получение Byte значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено null.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено null.
     *
     * @param keyString Ключ
     * @return Значение по ключу или null.
     */
    public @Nullable Byte getByteOrNull(String keyString) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        if (!container.has(key)) return null;
        if (!container.has(key, PersistentDataType.BYTE)) return null;
        return container.get(key, PersistentDataType.BYTE);
    }

    /**
     * Получение Byte значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено значение по умолчанию.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено значение по умолчанию.
     *
     * @param keyString Ключ
     * @param defaultValue Значение по умолчанию
     * @return Значение по ключу или значение по умолчанию.
     */
    public Byte getByteOrDefault(String keyString, Byte defaultValue) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        if (!container.has(key)) return defaultValue;
        if (!container.has(key, PersistentDataType.BYTE)) return defaultValue;
        return container.get(key, PersistentDataType.BYTE);
    }

    /**
     * Установка Byte значения по ключу.
     *
     * @param keyString Ключ
     * @param value Значение
     * @return Этот же менеджер.
     */
    public DataManager setByte(String keyString, byte value) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        container.set(key, PersistentDataType.BYTE, value);
        return this;
    }

    /**
     * Проверка значения по ключу на тип Short.
     * Если значения по ключу нет, будет возвращено false.
     *
     * @param key Ключ
     * @return Является ли значение по ключу Short.
     */
    public boolean isShort(NamespacedKey key) {
        return container.has(key, PersistentDataType.SHORT);
    }

    /**
     * Получение Short значения по ключу.
     * Если в контейнере нет указанного ключа, будет вызвано исключение.
     * Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     *
     * @param key Ключ
     * @return Значение по ключу.
     * @throws DataManagerKeyError Если в контейнере нет указанного ключа, будет вызвано исключение.
     * @throws DataManagerTypeError Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     */
    public short getShort(NamespacedKey key) {
        if (!container.has(key)) throw new DataManagerKeyError(key);
        if (!container.has(key, PersistentDataType.SHORT)) throw new DataManagerTypeError(PersistentDataType.SHORT);
        return container.get(key, PersistentDataType.SHORT);
    }

    /**
     * Получение Short значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено null.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено null.
     *
     * @param key Ключ
     * @return Значение по ключу или null.
     */
    public @Nullable Short getShortOrNull(NamespacedKey key) {
        if (!container.has(key)) return null;
        if (!container.has(key, PersistentDataType.SHORT)) return null;
        return container.get(key, PersistentDataType.SHORT);
    }

    /**
     * Получение Short значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено значение по умолчанию.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено значение по умолчанию.
     *
     * @param key Ключ
     * @param defaultValue Значение по умолчанию
     * @return Значение по ключу или значение по умолчанию.
     */
    public Short getShortOrDefault(NamespacedKey key, Short defaultValue) {
        if (!container.has(key)) return defaultValue;
        if (!container.has(key, PersistentDataType.SHORT)) return defaultValue;
        return container.get(key, PersistentDataType.SHORT);
    }

    /**
     * Установка Short значения по ключу.
     *
     * @param key Ключ
     * @param value Значение
     * @return Этот же менеджер.
     */
    public DataManager setShort(NamespacedKey key, short value) {
        container.set(key, PersistentDataType.SHORT, value);
        return this;
    }

    /**
     * Проверка значения по ключу на тип Short.
     * Если значения по ключу нет, будет возвращено false.
     *
     * @param keyString Ключ
     * @return Является ли значение по ключу Short.
     */
    public boolean isShort(String keyString) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        return container.has(key, PersistentDataType.SHORT);
    }

    /**
     * Получение Short значения по ключу.
     * Если в контейнере нет указанного ключа, будет вызвано исключение.
     * Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     *
     * @param keyString Ключ
     * @return Значение по ключу.
     * @throws DataManagerKeyError Если в контейнере нет указанного ключа, будет вызвано исключение.
     * @throws DataManagerTypeError Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     */
    public short getShort(String keyString) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        if (!container.has(key)) throw new DataManagerKeyError(key);
        if (!container.has(key, PersistentDataType.SHORT)) throw new DataManagerTypeError(PersistentDataType.SHORT);
        return container.get(key, PersistentDataType.SHORT);
    }

    /**
     * Получение Short значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено null.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено null.
     *
     * @param keyString Ключ
     * @return Значение по ключу или null.
     */
    public @Nullable Short getShortOrNull(String keyString) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        if (!container.has(key)) return null;
        if (!container.has(key, PersistentDataType.SHORT)) return null;
        return container.get(key, PersistentDataType.SHORT);
    }

    /**
     * Получение Short значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено значение по умолчанию.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено значение по умолчанию.
     *
     * @param keyString Ключ
     * @param defaultValue Значение по умолчанию
     * @return Значение по ключу или значение по умолчанию.
     */
    public Short getShortOrDefault(String keyString, Short defaultValue) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        if (!container.has(key)) return defaultValue;
        if (!container.has(key, PersistentDataType.SHORT)) return defaultValue;
        return container.get(key, PersistentDataType.SHORT);
    }

    /**
     * Установка Short значения по ключу.
     *
     * @param keyString Ключ
     * @param value Значение
     * @return Этот же менеджер.
     */
    public DataManager setShort(String keyString, short value) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        container.set(key, PersistentDataType.SHORT, value);
        return this;
    }

    /**
     * Проверка значения по ключу на тип Integer.
     * Если значения по ключу нет, будет возвращено false.
     *
     * @param key Ключ
     * @return Является ли значение по ключу Integer.
     */
    public boolean isInteger(NamespacedKey key) {
        return container.has(key, PersistentDataType.INTEGER);
    }

    /**
     * Получение Integer значения по ключу.
     * Если в контейнере нет указанного ключа, будет вызвано исключение.
     * Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     *
     * @param key Ключ
     * @return Значение по ключу.
     * @throws DataManagerKeyError Если в контейнере нет указанного ключа, будет вызвано исключение.
     * @throws DataManagerTypeError Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     */
    public int getInteger(NamespacedKey key) {
        if (!container.has(key)) throw new DataManagerKeyError(key);
        if (!container.has(key, PersistentDataType.INTEGER)) throw new DataManagerTypeError(PersistentDataType.INTEGER);
        return container.get(key, PersistentDataType.INTEGER);
    }

    /**
     * Получение Integer значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено null.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено null.
     *
     * @param key Ключ
     * @return Значение по ключу или null.
     */
    public @Nullable Integer getIntegerOrNull(NamespacedKey key) {
        if (!container.has(key)) return null;
        if (!container.has(key, PersistentDataType.INTEGER)) return null;
        return container.get(key, PersistentDataType.INTEGER);
    }

    /**
     * Получение Integer значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено значение по умолчанию.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено значение по умолчанию.
     *
     * @param key Ключ
     * @param defaultValue Значение по умолчанию
     * @return Значение по ключу или значение по умолчанию.
     */
    public Integer getIntegerOrDefault(NamespacedKey key, Integer defaultValue) {
        if (!container.has(key)) return defaultValue;
        if (!container.has(key, PersistentDataType.INTEGER)) return defaultValue;
        return container.get(key, PersistentDataType.INTEGER);
    }

    /**
     * Установка Integer значения по ключу.
     *
     * @param key Ключ
     * @param value Значение
     * @return Этот же менеджер.
     */
    public DataManager setInteger(NamespacedKey key, int value) {
        container.set(key, PersistentDataType.INTEGER, value);
        return this;
    }

    /**
     * Проверка значения по ключу на тип Integer.
     * Если значения по ключу нет, будет возвращено false.
     *
     * @param keyString Ключ
     * @return Является ли значение по ключу Integer.
     */
    public boolean isInteger(String keyString) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        return container.has(key, PersistentDataType.INTEGER);
    }

    /**
     * Получение Integer значения по ключу.
     * Если в контейнере нет указанного ключа, будет вызвано исключение.
     * Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     *
     * @param keyString Ключ
     * @return Значение по ключу.
     * @throws DataManagerKeyError Если в контейнере нет указанного ключа, будет вызвано исключение.
     * @throws DataManagerTypeError Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     */
    public int getInteger(String keyString) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        if (!container.has(key)) throw new DataManagerKeyError(key);
        if (!container.has(key, PersistentDataType.INTEGER)) throw new DataManagerTypeError(PersistentDataType.INTEGER);
        return container.get(key, PersistentDataType.INTEGER);
    }

    /**
     * Получение Integer значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено null.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено null.
     *
     * @param keyString Ключ
     * @return Значение по ключу или null.
     */
    public @Nullable Integer getIntegerOrNull(String keyString) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        if (!container.has(key)) return null;
        if (!container.has(key, PersistentDataType.INTEGER)) return null;
        return container.get(key, PersistentDataType.INTEGER);
    }

    /**
     * Получение Integer значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено значение по умолчанию.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено значение по умолчанию.
     *
     * @param keyString Ключ
     * @param defaultValue Значение по умолчанию
     * @return Значение по ключу или значение по умолчанию.
     */
    public Integer getIntegerOrDefault(String keyString, Integer defaultValue) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        if (!container.has(key)) return defaultValue;
        if (!container.has(key, PersistentDataType.INTEGER)) return defaultValue;
        return container.get(key, PersistentDataType.INTEGER);
    }

    /**
     * Установка Integer значения по ключу.
     *
     * @param keyString Ключ
     * @param value Значение
     * @return Этот же менеджер.
     */
    public DataManager setInteger(String keyString, int value) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        container.set(key, PersistentDataType.INTEGER, value);
        return this;
    }

    /**
     * Проверка значения по ключу на тип Long.
     * Если значения по ключу нет, будет возвращено false.
     *
     * @param key Ключ
     * @return Является ли значение по ключу Long.
     */
    public boolean isLong(NamespacedKey key) {
        return container.has(key, PersistentDataType.LONG);
    }

    /**
     * Получение Long значения по ключу.
     * Если в контейнере нет указанного ключа, будет вызвано исключение.
     * Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     *
     * @param key Ключ
     * @return Значение по ключу.
     * @throws DataManagerKeyError Если в контейнере нет указанного ключа, будет вызвано исключение.
     * @throws DataManagerTypeError Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     */
    public long getLong(NamespacedKey key) {
        if (!container.has(key)) throw new DataManagerKeyError(key);
        if (!container.has(key, PersistentDataType.LONG)) throw new DataManagerTypeError(PersistentDataType.LONG);
        return container.get(key, PersistentDataType.LONG);
    }

    /**
     * Получение Long значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено null.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено null.
     *
     * @param key Ключ
     * @return Значение по ключу или null.
     */
    public @Nullable Long getLongOrNull(NamespacedKey key) {
        if (!container.has(key)) return null;
        if (!container.has(key, PersistentDataType.LONG)) return null;
        return container.get(key, PersistentDataType.LONG);
    }

    /**
     * Получение Long значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено значение по умолчанию.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено значение по умолчанию.
     *
     * @param key Ключ
     * @param defaultValue Значение по умолчанию
     * @return Значение по ключу или значение по умолчанию.
     */
    public Long getLongOrDefault(NamespacedKey key, Long defaultValue) {
        if (!container.has(key)) return defaultValue;
        if (!container.has(key, PersistentDataType.LONG)) return defaultValue;
        return container.get(key, PersistentDataType.LONG);
    }

    /**
     * Установка Long значения по ключу.
     *
     * @param key Ключ
     * @param value Значение
     * @return Этот же менеджер.
     */
    public DataManager setLong(NamespacedKey key, long value) {
        container.set(key, PersistentDataType.LONG, value);
        return this;
    }

    /**
     * Проверка значения по ключу на тип Long.
     * Если значения по ключу нет, будет возвращено false.
     *
     * @param keyString Ключ
     * @return Является ли значение по ключу Long.
     */
    public boolean isLong(String keyString) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        return container.has(key, PersistentDataType.LONG);
    }

    /**
     * Получение Long значения по ключу.
     * Если в контейнере нет указанного ключа, будет вызвано исключение.
     * Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     *
     * @param keyString Ключ
     * @return Значение по ключу.
     * @throws DataManagerKeyError Если в контейнере нет указанного ключа, будет вызвано исключение.
     * @throws DataManagerTypeError Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     */
    public long getLong(String keyString) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        if (!container.has(key)) throw new DataManagerKeyError(key);
        if (!container.has(key, PersistentDataType.LONG)) throw new DataManagerTypeError(PersistentDataType.LONG);
        return container.get(key, PersistentDataType.LONG);
    }

    /**
     * Получение Long значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено null.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено null.
     *
     * @param keyString Ключ
     * @return Значение по ключу или null.
     */
    public @Nullable Long getLongOrNull(String keyString) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        if (!container.has(key)) return null;
        if (!container.has(key, PersistentDataType.LONG)) return null;
        return container.get(key, PersistentDataType.LONG);
    }

    /**
     * Получение Long значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено значение по умолчанию.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено значение по умолчанию.
     *
     * @param keyString Ключ
     * @param defaultValue Значение по умолчанию
     * @return Значение по ключу или значение по умолчанию.
     */
    public Long getLongOrDefault(String keyString, Long defaultValue) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        if (!container.has(key)) return defaultValue;
        if (!container.has(key, PersistentDataType.LONG)) return defaultValue;
        return container.get(key, PersistentDataType.LONG);
    }

    /**
     * Установка Long значения по ключу.
     *
     * @param keyString Ключ
     * @param value Значение
     * @return Этот же менеджер.
     */
    public DataManager setLong(String keyString, long value) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        container.set(key, PersistentDataType.LONG, value);
        return this;
    }

    /**
     * Проверка значения по ключу на тип Float.
     * Если значения по ключу нет, будет возвращено false.
     *
     * @param key Ключ
     * @return Является ли значение по ключу Float.
     */
    public boolean isFloat(NamespacedKey key) {
        return container.has(key, PersistentDataType.FLOAT);
    }

    /**
     * Получение Float значения по ключу.
     * Если в контейнере нет указанного ключа, будет вызвано исключение.
     * Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     *
     * @param key Ключ
     * @return Значение по ключу.
     * @throws DataManagerKeyError Если в контейнере нет указанного ключа, будет вызвано исключение.
     * @throws DataManagerTypeError Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     */
    public float getFloat(NamespacedKey key) {
        if (!container.has(key)) throw new DataManagerKeyError(key);
        if (!container.has(key, PersistentDataType.FLOAT)) throw new DataManagerTypeError(PersistentDataType.FLOAT);
        return container.get(key, PersistentDataType.FLOAT);
    }

    /**
     * Получение Float значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено null.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено null.
     *
     * @param key Ключ
     * @return Значение по ключу или null.
     */
    public @Nullable Float getFloatOrNull(NamespacedKey key) {
        if (!container.has(key)) return null;
        if (!container.has(key, PersistentDataType.FLOAT)) return null;
        return container.get(key, PersistentDataType.FLOAT);
    }

    /**
     * Получение Float значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено значение по умолчанию.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено значение по умолчанию.
     *
     * @param key Ключ
     * @param defaultValue Значение по умолчанию
     * @return Значение по ключу или значение по умолчанию.
     */
    public Float getFloatOrDefault(NamespacedKey key, Float defaultValue) {
        if (!container.has(key)) return defaultValue;
        if (!container.has(key, PersistentDataType.FLOAT)) return defaultValue;
        return container.get(key, PersistentDataType.FLOAT);
    }

    /**
     * Установка Float значения по ключу.
     *
     * @param key Ключ
     * @param value Значение
     * @return Этот же менеджер.
     */
    public DataManager setFloat(NamespacedKey key, float value) {
        container.set(key, PersistentDataType.FLOAT, value);
        return this;
    }

    /**
     * Проверка значения по ключу на тип Float.
     * Если значения по ключу нет, будет возвращено false.
     *
     * @param keyString Ключ
     * @return Является ли значение по ключу Float.
     */
    public boolean isFloat(String keyString) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        return container.has(key, PersistentDataType.FLOAT);
    }

    /**
     * Получение Float значения по ключу.
     * Если в контейнере нет указанного ключа, будет вызвано исключение.
     * Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     *
     * @param keyString Ключ
     * @return Значение по ключу.
     * @throws DataManagerKeyError Если в контейнере нет указанного ключа, будет вызвано исключение.
     * @throws DataManagerTypeError Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     */
    public float getFloat(String keyString) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        if (!container.has(key)) throw new DataManagerKeyError(key);
        if (!container.has(key, PersistentDataType.FLOAT)) throw new DataManagerTypeError(PersistentDataType.FLOAT);
        return container.get(key, PersistentDataType.FLOAT);
    }

    /**
     * Получение Float значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено null.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено null.
     *
     * @param keyString Ключ
     * @return Значение по ключу или null.
     */
    public @Nullable Float getFloatOrNull(String keyString) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        if (!container.has(key)) return null;
        if (!container.has(key, PersistentDataType.FLOAT)) return null;
        return container.get(key, PersistentDataType.FLOAT);
    }

    /**
     * Получение Float значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено значение по умолчанию.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено значение по умолчанию.
     *
     * @param keyString Ключ
     * @param defaultValue Значение по умолчанию
     * @return Значение по ключу или значение по умолчанию.
     */
    public Float getFloatOrDefault(String keyString, Float defaultValue) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        if (!container.has(key)) return defaultValue;
        if (!container.has(key, PersistentDataType.FLOAT)) return defaultValue;
        return container.get(key, PersistentDataType.FLOAT);
    }

    /**
     * Установка Float значения по ключу.
     *
     * @param keyString Ключ
     * @param value Значение
     * @return Этот же менеджер.
     */
    public DataManager setFloat(String keyString, float value) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        container.set(key, PersistentDataType.FLOAT, value);
        return this;
    }

    /**
     * Проверка значения по ключу на тип Double.
     * Если значения по ключу нет, будет возвращено false.
     *
     * @param key Ключ
     * @return Является ли значение по ключу Double.
     */
    public boolean isDouble(NamespacedKey key) {
        return container.has(key, PersistentDataType.DOUBLE);
    }

    /**
     * Получение Double значения по ключу.
     * Если в контейнере нет указанного ключа, будет вызвано исключение.
     * Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     *
     * @param key Ключ
     * @return Значение по ключу.
     * @throws DataManagerKeyError Если в контейнере нет указанного ключа, будет вызвано исключение.
     * @throws DataManagerTypeError Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     */
    public double getDouble(NamespacedKey key) {
        if (!container.has(key)) throw new DataManagerKeyError(key);
        if (!container.has(key, PersistentDataType.DOUBLE)) throw new DataManagerTypeError(PersistentDataType.DOUBLE);
        return container.get(key, PersistentDataType.DOUBLE);
    }

    /**
     * Получение Double значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено null.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено null.
     *
     * @param key Ключ
     * @return Значение по ключу или null.
     */
    public @Nullable Double getDoubleOrNull(NamespacedKey key) {
        if (!container.has(key)) return null;
        if (!container.has(key, PersistentDataType.DOUBLE)) return null;
        return container.get(key, PersistentDataType.DOUBLE);
    }

    /**
     * Получение Double значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено значение по умолчанию.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено значение по умолчанию.
     *
     * @param key Ключ
     * @param defaultValue Значение по умолчанию
     * @return Значение по ключу или значение по умолчанию.
     */
    public Double getDoubleOrDefault(NamespacedKey key, Double defaultValue) {
        if (!container.has(key)) return defaultValue;
        if (!container.has(key, PersistentDataType.DOUBLE)) return defaultValue;
        return container.get(key, PersistentDataType.DOUBLE);
    }

    /**
     * Установка Double значения по ключу.
     *
     * @param key Ключ
     * @param value Значение
     * @return Этот же менеджер.
     */
    public DataManager setDouble(NamespacedKey key, double value) {
        container.set(key, PersistentDataType.DOUBLE, value);
        return this;
    }

    /**
     * Проверка значения по ключу на тип Double.
     * Если значения по ключу нет, будет возвращено false.
     *
     * @param keyString Ключ
     * @return Является ли значение по ключу Double.
     */
    public boolean isDouble(String keyString) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        return container.has(key, PersistentDataType.DOUBLE);
    }

    /**
     * Получение Double значения по ключу.
     * Если в контейнере нет указанного ключа, будет вызвано исключение.
     * Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     *
     * @param keyString Ключ
     * @return Значение по ключу.
     * @throws DataManagerKeyError Если в контейнере нет указанного ключа, будет вызвано исключение.
     * @throws DataManagerTypeError Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     */
    public double getDouble(String keyString) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        if (!container.has(key)) throw new DataManagerKeyError(key);
        if (!container.has(key, PersistentDataType.DOUBLE)) throw new DataManagerTypeError(PersistentDataType.DOUBLE);
        return container.get(key, PersistentDataType.DOUBLE);
    }

    /**
     * Получение Double значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено null.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено null.
     *
     * @param keyString Ключ
     * @return Значение по ключу или null.
     */
    public @Nullable Double getDoubleOrNull(String keyString) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        if (!container.has(key)) return null;
        if (!container.has(key, PersistentDataType.DOUBLE)) return null;
        return container.get(key, PersistentDataType.DOUBLE);
    }

    /**
     * Получение Double значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено значение по умолчанию.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено значение по умолчанию.
     *
     * @param keyString Ключ
     * @param defaultValue Значение по умолчанию
     * @return Значение по ключу или значение по умолчанию.
     */
    public Double getDoubleOrDefault(String keyString, Double defaultValue) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        if (!container.has(key)) return defaultValue;
        if (!container.has(key, PersistentDataType.DOUBLE)) return defaultValue;
        return container.get(key, PersistentDataType.DOUBLE);
    }

    /**
     * Установка Double значения по ключу.
     *
     * @param keyString Ключ
     * @param value Значение
     * @return Этот же менеджер.
     */
    public DataManager setDouble(String keyString, double value) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        container.set(key, PersistentDataType.DOUBLE, value);
        return this;
    }

    /**
     * Проверка значения по ключу на тип Boolean.
     * Если значения по ключу нет, будет возвращено false.
     *
     * @param key Ключ
     * @return Является ли значение по ключу Boolean.
     */
    public boolean isBoolean(NamespacedKey key) {
        return container.has(key, PersistentDataType.BOOLEAN);
    }

    /**
     * Получение Boolean значения по ключу.
     * Если в контейнере нет указанного ключа, будет вызвано исключение.
     * Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     *
     * @param key Ключ
     * @return Значение по ключу.
     * @throws DataManagerKeyError Если в контейнере нет указанного ключа, будет вызвано исключение.
     * @throws DataManagerTypeError Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     */
    public boolean getBoolean(NamespacedKey key) {
        if (!container.has(key)) throw new DataManagerKeyError(key);
        if (!container.has(key, PersistentDataType.BOOLEAN)) throw new DataManagerTypeError(PersistentDataType.BOOLEAN);
        return container.get(key, PersistentDataType.BOOLEAN);
    }

    /**
     * Получение Boolean значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено null.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено null.
     *
     * @param key Ключ
     * @return Значение по ключу или null.
     */
    public @Nullable Boolean getBooleanOrNull(NamespacedKey key) {
        if (!container.has(key)) return null;
        if (!container.has(key, PersistentDataType.BOOLEAN)) return null;
        return container.get(key, PersistentDataType.BOOLEAN);
    }

    /**
     * Получение Boolean значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено значение по умолчанию.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено значение по умолчанию.
     *
     * @param key Ключ
     * @param defaultValue Значение по умолчанию
     * @return Значение по ключу или значение по умолчанию.
     */
    public Boolean getBooleanOrDefault(NamespacedKey key, Boolean defaultValue) {
        if (!container.has(key)) return defaultValue;
        if (!container.has(key, PersistentDataType.BOOLEAN)) return defaultValue;
        return container.get(key, PersistentDataType.BOOLEAN);
    }

    /**
     * Установка Boolean значения по ключу.
     *
     * @param key Ключ
     * @param value Значение
     * @return Этот же менеджер.
     */
    public DataManager setBoolean(NamespacedKey key, boolean value) {
        container.set(key, PersistentDataType.BOOLEAN, value);
        return this;
    }

    /**
     * Проверка значения по ключу на тип Boolean.
     * Если значения по ключу нет, будет возвращено false.
     *
     * @param keyString Ключ
     * @return Является ли значение по ключу Boolean.
     */
    public boolean isBoolean(String keyString) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        return container.has(key, PersistentDataType.BOOLEAN);
    }

    /**
     * Получение Boolean значения по ключу.
     * Если в контейнере нет указанного ключа, будет вызвано исключение.
     * Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     *
     * @param keyString Ключ
     * @return Значение по ключу.
     * @throws DataManagerKeyError Если в контейнере нет указанного ключа, будет вызвано исключение.
     * @throws DataManagerTypeError Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     */
    public boolean getBoolean(String keyString) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        if (!container.has(key)) throw new DataManagerKeyError(key);
        if (!container.has(key, PersistentDataType.BOOLEAN)) throw new DataManagerTypeError(PersistentDataType.BOOLEAN);
        return container.get(key, PersistentDataType.BOOLEAN);
    }

    /**
     * Получение Boolean значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено null.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено null.
     *
     * @param keyString Ключ
     * @return Значение по ключу или null.
     */
    public @Nullable Boolean getBooleanOrNull(String keyString) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        if (!container.has(key)) return null;
        if (!container.has(key, PersistentDataType.BOOLEAN)) return null;
        return container.get(key, PersistentDataType.BOOLEAN);
    }

    /**
     * Получение Boolean значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено значение по умолчанию.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено значение по умолчанию.
     *
     * @param keyString Ключ
     * @param defaultValue Значение по умолчанию
     * @return Значение по ключу или значение по умолчанию.
     */
    public Boolean getBooleanOrDefault(String keyString, Boolean defaultValue) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        if (!container.has(key)) return defaultValue;
        if (!container.has(key, PersistentDataType.BOOLEAN)) return defaultValue;
        return container.get(key, PersistentDataType.BOOLEAN);
    }

    /**
     * Установка Boolean значения по ключу.
     *
     * @param keyString Ключ
     * @param value Значение
     * @return Этот же менеджер.
     */
    public DataManager setBoolean(String keyString, boolean value) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        container.set(key, PersistentDataType.BOOLEAN, value);
        return this;
    }

    /**
     * Проверка значения по ключу на тип String.
     * Если значения по ключу нет, будет возвращено false.
     *
     * @param key Ключ
     * @return Является ли значение по ключу String.
     */
    public boolean isString(NamespacedKey key) {
        return container.has(key, PersistentDataType.STRING);
    }

    /**
     * Получение String значения по ключу.
     * Если в контейнере нет указанного ключа, будет вызвано исключение.
     * Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     *
     * @param key Ключ
     * @return Значение по ключу.
     * @throws DataManagerKeyError Если в контейнере нет указанного ключа, будет вызвано исключение.
     * @throws DataManagerTypeError Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     */
    public String getString(NamespacedKey key) {
        if (!container.has(key)) throw new DataManagerKeyError(key);
        if (!container.has(key, PersistentDataType.STRING)) throw new DataManagerTypeError(PersistentDataType.STRING);
        return container.get(key, PersistentDataType.STRING);
    }

    /**
     * Получение String значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено null.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено null.
     *
     * @param key Ключ
     * @return Значение по ключу или null.
     */
    public @Nullable String getStringOrNull(NamespacedKey key) {
        if (!container.has(key)) return null;
        if (!container.has(key, PersistentDataType.STRING)) return null;
        return container.get(key, PersistentDataType.STRING);
    }

    /**
     * Получение String значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено значение по умолчанию.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено значение по умолчанию.
     *
     * @param key Ключ
     * @param defaultValue Значение по умолчанию
     * @return Значение по ключу или значение по умолчанию.
     */
    public String getStringOrDefault(NamespacedKey key, String defaultValue) {
        if (!container.has(key)) return defaultValue;
        if (!container.has(key, PersistentDataType.STRING)) return defaultValue;
        return container.get(key, PersistentDataType.STRING);
    }

    /**
     * Установка String значения по ключу.
     *
     * @param key Ключ
     * @param value Значение
     * @return Этот же менеджер.
     */
    public DataManager setString(NamespacedKey key, String value) {
        container.set(key, PersistentDataType.STRING, value);
        return this;
    }

    /**
     * Проверка значения по ключу на тип String.
     * Если значения по ключу нет, будет возвращено false.
     *
     * @param keyString Ключ
     * @return Является ли значение по ключу String.
     */
    public boolean isString(String keyString) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        return container.has(key, PersistentDataType.STRING);
    }

    /**
     * Получение String значения по ключу.
     * Если в контейнере нет указанного ключа, будет вызвано исключение.
     * Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     *
     * @param keyString Ключ
     * @return Значение по ключу.
     * @throws DataManagerKeyError Если в контейнере нет указанного ключа, будет вызвано исключение.
     * @throws DataManagerTypeError Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     */
    public String getString(String keyString) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        if (!container.has(key)) throw new DataManagerKeyError(key);
        if (!container.has(key, PersistentDataType.STRING)) throw new DataManagerTypeError(PersistentDataType.STRING);
        return container.get(key, PersistentDataType.STRING);
    }

    /**
     * Получение String значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено null.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено null.
     *
     * @param keyString Ключ
     * @return Значение по ключу или null.
     */
    public @Nullable String getStringOrNull(String keyString) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        if (!container.has(key)) return null;
        if (!container.has(key, PersistentDataType.STRING)) return null;
        return container.get(key, PersistentDataType.STRING);
    }

    /**
     * Получение String значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено значение по умолчанию.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено значение по умолчанию.
     *
     * @param keyString Ключ
     * @param defaultValue Значение по умолчанию
     * @return Значение по ключу или значение по умолчанию.
     */
    public String getStringOrDefault(String keyString, String defaultValue) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        if (!container.has(key)) return defaultValue;
        if (!container.has(key, PersistentDataType.STRING)) return defaultValue;
        return container.get(key, PersistentDataType.STRING);
    }

    /**
     * Установка String значения по ключу.
     *
     * @param keyString Ключ
     * @param value Значение
     * @return Этот же менеджер.
     */
    public DataManager setString(String keyString, String value) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        container.set(key, PersistentDataType.STRING, value);
        return this;
    }

    /**
     * Проверка значения по ключу на тип ByteArray.
     * Если значения по ключу нет, будет возвращено false.
     *
     * @param key Ключ
     * @return Является ли значение по ключу ByteArray.
     */
    public boolean isByteArray(NamespacedKey key) {
        return container.has(key, PersistentDataType.BYTE_ARRAY);
    }

    /**
     * Получение ByteArray значения по ключу.
     * Если в контейнере нет указанного ключа, будет вызвано исключение.
     * Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     *
     * @param key Ключ
     * @return Значение по ключу.
     * @throws DataManagerKeyError Если в контейнере нет указанного ключа, будет вызвано исключение.
     * @throws DataManagerTypeError Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     */
    public byte[] getByteArray(NamespacedKey key) {
        if (!container.has(key)) throw new DataManagerKeyError(key);
        if (!container.has(key, PersistentDataType.BYTE_ARRAY)) throw new DataManagerTypeError(PersistentDataType.BYTE_ARRAY);
        return container.get(key, PersistentDataType.BYTE_ARRAY);
    }

    /**
     * Получение ByteArray значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено null.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено null.
     *
     * @param key Ключ
     * @return Значение по ключу или null.
     */
    public @Nullable byte[] getByteArrayOrNull(NamespacedKey key) {
        if (!container.has(key)) return null;
        if (!container.has(key, PersistentDataType.BYTE_ARRAY)) return null;
        return container.get(key, PersistentDataType.BYTE_ARRAY);
    }

    /**
     * Получение ByteArray значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено значение по умолчанию.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено значение по умолчанию.
     *
     * @param key Ключ
     * @param defaultValue Значение по умолчанию
     * @return Значение по ключу или значение по умолчанию.
     */
    public byte[] getByteArrayOrDefault(NamespacedKey key, byte[] defaultValue) {
        if (!container.has(key)) return defaultValue;
        if (!container.has(key, PersistentDataType.BYTE_ARRAY)) return defaultValue;
        return container.get(key, PersistentDataType.BYTE_ARRAY);
    }

    /**
     * Установка ByteArray значения по ключу.
     *
     * @param key Ключ
     * @param value Значение
     * @return Этот же менеджер.
     */
    public DataManager setByteArray(NamespacedKey key, byte[] value) {
        container.set(key, PersistentDataType.BYTE_ARRAY, value);
        return this;
    }

    /**
     * Проверка значения по ключу на тип ByteArray.
     * Если значения по ключу нет, будет возвращено false.
     *
     * @param keyString Ключ
     * @return Является ли значение по ключу ByteArray.
     */
    public boolean isByteArray(String keyString) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        return container.has(key, PersistentDataType.BYTE_ARRAY);
    }

    /**
     * Получение ByteArray значения по ключу.
     * Если в контейнере нет указанного ключа, будет вызвано исключение.
     * Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     *
     * @param keyString Ключ
     * @return Значение по ключу.
     * @throws DataManagerKeyError Если в контейнере нет указанного ключа, будет вызвано исключение.
     * @throws DataManagerTypeError Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     */
    public byte[] getByteArray(String keyString) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        if (!container.has(key)) throw new DataManagerKeyError(key);
        if (!container.has(key, PersistentDataType.BYTE_ARRAY)) throw new DataManagerTypeError(PersistentDataType.BYTE_ARRAY);
        return container.get(key, PersistentDataType.BYTE_ARRAY);
    }

    /**
     * Получение ByteArray значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено null.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено null.
     *
     * @param keyString Ключ
     * @return Значение по ключу или null.
     */
    public @Nullable byte[] getByteArrayOrNull(String keyString) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        if (!container.has(key)) return null;
        if (!container.has(key, PersistentDataType.BYTE_ARRAY)) return null;
        return container.get(key, PersistentDataType.BYTE_ARRAY);
    }

    /**
     * Получение ByteArray значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено значение по умолчанию.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено значение по умолчанию.
     *
     * @param keyString Ключ
     * @param defaultValue Значение по умолчанию
     * @return Значение по ключу или значение по умолчанию.
     */
    public byte[] getByteArrayOrDefault(String keyString, byte[] defaultValue) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        if (!container.has(key)) return defaultValue;
        if (!container.has(key, PersistentDataType.BYTE_ARRAY)) return defaultValue;
        return container.get(key, PersistentDataType.BYTE_ARRAY);
    }

    /**
     * Установка ByteArray значения по ключу.
     *
     * @param keyString Ключ
     * @param value Значение
     * @return Этот же менеджер.
     */
    public DataManager setByteArray(String keyString, byte[] value) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        container.set(key, PersistentDataType.BYTE_ARRAY, value);
        return this;
    }

    /**
     * Проверка значения по ключу на тип IntegerArray.
     * Если значения по ключу нет, будет возвращено false.
     *
     * @param key Ключ
     * @return Является ли значение по ключу IntegerArray.
     */
    public boolean isIntegerArray(NamespacedKey key) {
        return container.has(key, PersistentDataType.INTEGER_ARRAY);
    }

    /**
     * Получение IntegerArray значения по ключу.
     * Если в контейнере нет указанного ключа, будет вызвано исключение.
     * Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     *
     * @param key Ключ
     * @return Значение по ключу.
     * @throws DataManagerKeyError Если в контейнере нет указанного ключа, будет вызвано исключение.
     * @throws DataManagerTypeError Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     */
    public int[] getIntegerArray(NamespacedKey key) {
        if (!container.has(key)) throw new DataManagerKeyError(key);
        if (!container.has(key, PersistentDataType.INTEGER_ARRAY)) throw new DataManagerTypeError(PersistentDataType.INTEGER_ARRAY);
        return container.get(key, PersistentDataType.INTEGER_ARRAY);
    }

    /**
     * Получение IntegerArray значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено null.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено null.
     *
     * @param key Ключ
     * @return Значение по ключу или null.
     */
    public @Nullable int[] getIntegerArrayOrNull(NamespacedKey key) {
        if (!container.has(key)) return null;
        if (!container.has(key, PersistentDataType.INTEGER_ARRAY)) return null;
        return container.get(key, PersistentDataType.INTEGER_ARRAY);
    }

    /**
     * Получение IntegerArray значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено значение по умолчанию.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено значение по умолчанию.
     *
     * @param key Ключ
     * @param defaultValue Значение по умолчанию
     * @return Значение по ключу или значение по умолчанию.
     */
    public int[] getIntegerArrayOrDefault(NamespacedKey key, int[] defaultValue) {
        if (!container.has(key)) return defaultValue;
        if (!container.has(key, PersistentDataType.INTEGER_ARRAY)) return defaultValue;
        return container.get(key, PersistentDataType.INTEGER_ARRAY);
    }

    /**
     * Установка IntegerArray значения по ключу.
     *
     * @param key Ключ
     * @param value Значение
     * @return Этот же менеджер.
     */
    public DataManager setIntegerArray(NamespacedKey key, int[] value) {
        container.set(key, PersistentDataType.INTEGER_ARRAY, value);
        return this;
    }

    /**
     * Проверка значения по ключу на тип IntegerArray.
     * Если значения по ключу нет, будет возвращено false.
     *
     * @param keyString Ключ
     * @return Является ли значение по ключу IntegerArray.
     */
    public boolean isIntegerArray(String keyString) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        return container.has(key, PersistentDataType.INTEGER_ARRAY);
    }

    /**
     * Получение IntegerArray значения по ключу.
     * Если в контейнере нет указанного ключа, будет вызвано исключение.
     * Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     *
     * @param keyString Ключ
     * @return Значение по ключу.
     * @throws DataManagerKeyError Если в контейнере нет указанного ключа, будет вызвано исключение.
     * @throws DataManagerTypeError Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     */
    public int[] getIntegerArray(String keyString) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        if (!container.has(key)) throw new DataManagerKeyError(key);
        if (!container.has(key, PersistentDataType.INTEGER_ARRAY)) throw new DataManagerTypeError(PersistentDataType.INTEGER_ARRAY);
        return container.get(key, PersistentDataType.INTEGER_ARRAY);
    }

    /**
     * Получение IntegerArray значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено null.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено null.
     *
     * @param keyString Ключ
     * @return Значение по ключу или null.
     */
    public @Nullable int[] getIntegerArrayOrNull(String keyString) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        if (!container.has(key)) return null;
        if (!container.has(key, PersistentDataType.INTEGER_ARRAY)) return null;
        return container.get(key, PersistentDataType.INTEGER_ARRAY);
    }

    /**
     * Получение IntegerArray значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено значение по умолчанию.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено значение по умолчанию.
     *
     * @param keyString Ключ
     * @param defaultValue Значение по умолчанию
     * @return Значение по ключу или значение по умолчанию.
     */
    public int[] getIntegerArrayOrDefault(String keyString, int[] defaultValue) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        if (!container.has(key)) return defaultValue;
        if (!container.has(key, PersistentDataType.INTEGER_ARRAY)) return defaultValue;
        return container.get(key, PersistentDataType.INTEGER_ARRAY);
    }

    /**
     * Установка IntegerArray значения по ключу.
     *
     * @param keyString Ключ
     * @param value Значение
     * @return Этот же менеджер.
     */
    public DataManager setIntegerArray(String keyString, int[] value) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        container.set(key, PersistentDataType.INTEGER_ARRAY, value);
        return this;
    }

    /**
     * Проверка значения по ключу на тип LongArray.
     * Если значения по ключу нет, будет возвращено false.
     *
     * @param key Ключ
     * @return Является ли значение по ключу LongArray.
     */
    public boolean isLongArray(NamespacedKey key) {
        return container.has(key, PersistentDataType.LONG_ARRAY);
    }

    /**
     * Получение LongArray значения по ключу.
     * Если в контейнере нет указанного ключа, будет вызвано исключение.
     * Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     *
     * @param key Ключ
     * @return Значение по ключу.
     * @throws DataManagerKeyError Если в контейнере нет указанного ключа, будет вызвано исключение.
     * @throws DataManagerTypeError Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     */
    public long[] getLongArray(NamespacedKey key) {
        if (!container.has(key)) throw new DataManagerKeyError(key);
        if (!container.has(key, PersistentDataType.LONG_ARRAY)) throw new DataManagerTypeError(PersistentDataType.LONG_ARRAY);
        return container.get(key, PersistentDataType.LONG_ARRAY);
    }

    /**
     * Получение LongArray значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено null.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено null.
     *
     * @param key Ключ
     * @return Значение по ключу или null.
     */
    public @Nullable long[] getLongArrayOrNull(NamespacedKey key) {
        if (!container.has(key)) return null;
        if (!container.has(key, PersistentDataType.LONG_ARRAY)) return null;
        return container.get(key, PersistentDataType.LONG_ARRAY);
    }

    /**
     * Получение LongArray значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено значение по умолчанию.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено значение по умолчанию.
     *
     * @param key Ключ
     * @param defaultValue Значение по умолчанию
     * @return Значение по ключу или значение по умолчанию.
     */
    public long[] getLongArrayOrDefault(NamespacedKey key, long[] defaultValue) {
        if (!container.has(key)) return defaultValue;
        if (!container.has(key, PersistentDataType.LONG_ARRAY)) return defaultValue;
        return container.get(key, PersistentDataType.LONG_ARRAY);
    }

    /**
     * Установка LongArray значения по ключу.
     *
     * @param key Ключ
     * @param value Значение
     * @return Этот же менеджер.
     */
    public DataManager setLongArray(NamespacedKey key, long[] value) {
        container.set(key, PersistentDataType.LONG_ARRAY, value);
        return this;
    }

    /**
     * Проверка значения по ключу на тип LongArray.
     * Если значения по ключу нет, будет возвращено false.
     *
     * @param keyString Ключ
     * @return Является ли значение по ключу LongArray.
     */
    public boolean isLongArray(String keyString) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        return container.has(key, PersistentDataType.LONG_ARRAY);
    }

    /**
     * Получение LongArray значения по ключу.
     * Если в контейнере нет указанного ключа, будет вызвано исключение.
     * Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     *
     * @param keyString Ключ
     * @return Значение по ключу.
     * @throws DataManagerKeyError Если в контейнере нет указанного ключа, будет вызвано исключение.
     * @throws DataManagerTypeError Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     */
    public long[] getLongArray(String keyString) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        if (!container.has(key)) throw new DataManagerKeyError(key);
        if (!container.has(key, PersistentDataType.LONG_ARRAY)) throw new DataManagerTypeError(PersistentDataType.LONG_ARRAY);
        return container.get(key, PersistentDataType.LONG_ARRAY);
    }

    /**
     * Получение LongArray значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено null.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено null.
     *
     * @param keyString Ключ
     * @return Значение по ключу или null.
     */
    public @Nullable long[] getLongArrayOrNull(String keyString) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        if (!container.has(key)) return null;
        if (!container.has(key, PersistentDataType.LONG_ARRAY)) return null;
        return container.get(key, PersistentDataType.LONG_ARRAY);
    }

    /**
     * Получение LongArray значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено значение по умолчанию.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено значение по умолчанию.
     *
     * @param keyString Ключ
     * @param defaultValue Значение по умолчанию
     * @return Значение по ключу или значение по умолчанию.
     */
    public long[] getLongArrayOrDefault(String keyString, long[] defaultValue) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        if (!container.has(key)) return defaultValue;
        if (!container.has(key, PersistentDataType.LONG_ARRAY)) return defaultValue;
        return container.get(key, PersistentDataType.LONG_ARRAY);
    }

    /**
     * Установка LongArray значения по ключу.
     *
     * @param keyString Ключ
     * @param value Значение
     * @return Этот же менеджер.
     */
    public DataManager setLongArray(String keyString, long[] value) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        container.set(key, PersistentDataType.LONG_ARRAY, value);
        return this;
    }

    /**
     * Проверка значения по ключу на тип Container.
     * Если значения по ключу нет, будет возвращено false.
     *
     * @param key Ключ
     * @return Является ли значение по ключу Container.
     */
    public boolean isContainer(NamespacedKey key) {
        return container.has(key, PersistentDataType.TAG_CONTAINER);
    }

    /**
     * Получение Container значения по ключу.
     * Если в контейнере нет указанного ключа, будет вызвано исключение.
     * Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     *
     * @param key Ключ
     * @return Значение по ключу.
     * @throws DataManagerKeyError Если в контейнере нет указанного ключа, будет вызвано исключение.
     * @throws DataManagerTypeError Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     */
    public DataManager getContainer(NamespacedKey key) {
        if (!container.has(key)) throw new DataManagerKeyError(key);
        if (!container.has(key, PersistentDataType.TAG_CONTAINER)) throw new DataManagerTypeError(PersistentDataType.TAG_CONTAINER);
        return new DataManager(container.get(key, PersistentDataType.TAG_CONTAINER));
    }

    /**
     * Получение Container значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено null.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено null.
     *
     * @param key Ключ
     * @return Значение по ключу или null.
     */
    public @Nullable DataManager getContainerOrNull(NamespacedKey key) {
        if (!container.has(key)) return null;
        if (!container.has(key, PersistentDataType.TAG_CONTAINER)) return null;
        return new DataManager(container.get(key, PersistentDataType.TAG_CONTAINER));
    }

    /**
     * Получение Container значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено значение по умолчанию.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено значение по умолчанию.
     *
     * @param key Ключ
     * @param defaultValue Значение по умолчанию
     * @return Значение по ключу или значение по умолчанию.
     */
    public DataManager getContainerOrDefault(NamespacedKey key, DataManager defaultValue) {
        if (!container.has(key)) return defaultValue;
        if (!container.has(key, PersistentDataType.TAG_CONTAINER)) return defaultValue;
        return new DataManager(container.get(key, PersistentDataType.TAG_CONTAINER));
    }

    /**
     * Установка Container значения по ключу.
     *
     * @param key Ключ
     * @param value Значение
     * @return Этот же менеджер.
     */
    public DataManager setContainer(NamespacedKey key, DataManager value) {
        container.set(key, PersistentDataType.TAG_CONTAINER, value.container);
        return this;
    }

    /**
     * Проверка значения по ключу на тип Container.
     * Если значения по ключу нет, будет возвращено false.
     *
     * @param keyString Ключ
     * @return Является ли значение по ключу Container.
     */
    public boolean isContainer(String keyString) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        return container.has(key, PersistentDataType.TAG_CONTAINER);
    }

    /**
     * Получение Container значения по ключу.
     * Если в контейнере нет указанного ключа, будет вызвано исключение.
     * Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     *
     * @param keyString Ключ
     * @return Значение по ключу.
     * @throws DataManagerKeyError Если в контейнере нет указанного ключа, будет вызвано исключение.
     * @throws DataManagerTypeError Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.
     */
    public DataManager getContainer(String keyString) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        if (!container.has(key)) throw new DataManagerKeyError(key);
        if (!container.has(key, PersistentDataType.TAG_CONTAINER)) throw new DataManagerTypeError(PersistentDataType.TAG_CONTAINER);
        return new DataManager(container.get(key, PersistentDataType.TAG_CONTAINER));
    }

    /**
     * Получение Container значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено null.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено null.
     *
     * @param keyString Ключ
     * @return Значение по ключу или null.
     */
    public @Nullable DataManager getContainerOrNull(String keyString) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        if (!container.has(key)) return null;
        if (!container.has(key, PersistentDataType.TAG_CONTAINER)) return null;
        return new DataManager(container.get(key, PersistentDataType.TAG_CONTAINER));
    }

    /**
     * Получение Container значения по ключу.
     * Если в контейнере нет указанного ключа, будет возвращено значение по умолчанию.
     * Если в контейнере значение по ключу неправильного типа, будет возвращено значение по умолчанию.
     *
     * @param keyString Ключ
     * @param defaultValue Значение по умолчанию
     * @return Значение по ключу или значение по умолчанию.
     */
    public DataManager getContainerOrDefault(String keyString, DataManager defaultValue) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        if (!container.has(key)) return defaultValue;
        if (!container.has(key, PersistentDataType.TAG_CONTAINER)) return defaultValue;
        return new DataManager(container.get(key, PersistentDataType.TAG_CONTAINER));
    }

    /**
     * Установка Container значения по ключу.
     *
     * @param keyString Ключ
     * @param value Значение
     * @return Этот же менеджер.
     */
    public DataManager setContainer(String keyString, DataManager value) {
        NamespacedKey key = new NamespacedKey(namespace, keyString);
        container.set(key, PersistentDataType.TAG_CONTAINER, value.container);
        return this;
    }
}