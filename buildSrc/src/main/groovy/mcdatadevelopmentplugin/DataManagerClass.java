package mcdatadevelopmentplugin;

import ru.vladislav117.jwriter.AccessModifier;
import ru.vladislav117.jwriter.Annotation;
import ru.vladislav117.jwriter.code.StatementBasedCode;
import ru.vladislav117.jwriter.field.Field;
import ru.vladislav117.jwriter.klass.Class;
import ru.vladislav117.jwriter.klass.ClassDocumentation;
import ru.vladislav117.jwriter.method.Argument;
import ru.vladislav117.jwriter.method.Method;
import ru.vladislav117.jwriter.method.MethodDocumentation;
import ru.vladislav117.jwriter.method.Return;

import java.util.ArrayList;
import java.util.List;

public class DataManagerClass extends Class {
    public static class DataManagerDataType {
        protected String name;
        protected String primitive;
        protected String klass;
        protected String type;
        protected boolean custom = false;

        public DataManagerDataType(String name, String primitive, String klass, String type) {
            this.name = name;
            this.primitive = primitive;
            this.klass = klass;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public String getPrimitive() {
            return primitive;
        }

        public String getKlass() {
            return klass;
        }

        public String getType() {
            return type;
        }

        public boolean isCustom() {
            return custom;
        }

        public DataManagerDataType setCustom(boolean custom) {
            this.custom = custom;
            return this;
        }
    }

    public static class DataManagerKeyType {
        protected Argument argument;
        protected boolean isString;

        public DataManagerKeyType(Argument argument, boolean isString) {
            this.argument = argument;
            this.isString = isString;
        }

        public Argument getArgument() {
            return argument;
        }

        public boolean isString() {
            return isString;
        }
    }

    public DataManagerClass() {
        super("DataManager");
        setDocumentation(new ClassDocumentation() {{
            addLine("Менеджер данных для PersistentDataContainer.");
        }});
        setAccessModifier(AccessModifier.PUBLIC);
        createFields();
        createMethods();
    }

    protected void createFields() {
        Field.defaultAccessModifier = AccessModifier.PROTECTED;
        addField(new Field("String", "defaultNamespace") {{
            setAccessModifier(AccessModifier.NOTHING);
            setStatic(true);
            setInitializer("\"minecraft\"");
        }});
        addField(new Field("String", "namespace"));
        addField(new Field("PersistentDataContainer", "container"));
    }

    protected void createMethods() {
        Method.defaultAccessModifier = AccessModifier.PUBLIC;
        addMethod(new Method(name) {{
            setDocumentation(new MethodDocumentation() {{
                addLine("Создание менеджера данных.");
            }});
            setConstructor(true);
            addArgument(new Argument("PersistentDataContainer", "container") {{
                setDescription("Контейнер");
            }});
            addArgument(new Argument("String", "namespace") {{
                setDescription("Пространство имён");
            }});
            setCode(new StatementBasedCode() {{
                addStatement("this.container = container");
                addStatement("this.namespace = namespace");
            }});
        }});

        addMethod(new Method(name) {{
            setDocumentation(new MethodDocumentation() {{
                addLine("Создание менеджера данных.");
            }});
            setConstructor(true);
            addArgument(new Argument("PersistentDataContainer", "container") {{
                setDescription("Контейнер");
            }});
            setCode(new StatementBasedCode() {{
                addStatement("this.container = container");
                addStatement("this.namespace = defaultNamespace");
            }});
        }});

        addMethod(new Method("getDefaultNamespace") {{
            setDocumentation(new MethodDocumentation() {{
                addLine("Получение пространства имён по умолчанию.");
            }});
            setStatic(true);
            setReturn(new Return("String") {{
                setDescription("Пространство имён по умолчанию.");
            }});
            setCode(new StatementBasedCode() {{
                addStatement("return defaultNamespace");
            }});
        }});

        addMethod(new Method("setDefaultNamespace") {{
            setDocumentation(new MethodDocumentation() {{
                addLine("Установка пространства имён по умолчанию.");
            }});
            setStatic(true);
            addArgument(new Argument("String", "defaultNamespace") {{
                setDescription("Пространство имён по умолчанию");
            }});
            setCode(new StatementBasedCode() {{
                addStatement("DataManager.defaultNamespace = defaultNamespace");
            }});
        }});

        addMethod(new Method("contains") {{
            setDocumentation(new MethodDocumentation() {{
                addLine("Проверка наличия ключа.");
            }});
            setReturn(new Return("boolean") {{
                setDescription("Наличие ключа.");
            }});
            addArgument(new Argument("NamespacedKey", "key") {{
                setDescription("Ключ");
            }});
            setCode(new StatementBasedCode() {{
                addStatement("return container.has(key)");
            }});
        }});

        addMethod(new Method("contains") {{
            setDocumentation(new MethodDocumentation() {{
                addLine("Проверка наличия ключа.");
            }});
            setReturn(new Return("boolean") {{
                setDescription("Наличие ключа.");
            }});
            addArgument(new Argument("String", "keyString") {{
                setDescription("Ключ");
            }});
            setCode(new StatementBasedCode() {{
                addStatement("NamespacedKey key = new NamespacedKey(namespace, keyString)");
                addStatement("return container.has(key)");
            }});
        }});
        createDataTypesMethods();
    }

    public void createDataTypesMethods() {
        List<DataManagerDataType> dataTypes = new ArrayList<>();
        dataTypes.add(new DataManagerDataType("Byte", "byte", "Byte", "BYTE"));
        dataTypes.add(new DataManagerDataType("Short", "short", "Short", "SHORT"));
        dataTypes.add(new DataManagerDataType("Integer", "int", "Integer", "INTEGER"));
        dataTypes.add(new DataManagerDataType("Long", "long", "Long", "LONG"));
        dataTypes.add(new DataManagerDataType("Float", "float", "Float", "FLOAT"));
        dataTypes.add(new DataManagerDataType("Double", "double", "Double", "DOUBLE"));
        dataTypes.add(new DataManagerDataType("Boolean", "boolean", "Boolean", "BOOLEAN"));
        dataTypes.add(new DataManagerDataType("String", "String", "String", "STRING"));
        dataTypes.add(new DataManagerDataType("ByteArray", "byte[]", "byte[]", "BYTE_ARRAY"));
        dataTypes.add(new DataManagerDataType("IntegerArray", "int[]", "int[]", "INTEGER_ARRAY"));
        dataTypes.add(new DataManagerDataType("LongArray", "long[]", "long[]", "LONG_ARRAY"));
        dataTypes.add(new DataManagerDataType("Container", "DataManager", "DataManager", "TAG_CONTAINER").setCustom(true));

        List<DataManagerKeyType> keyTypes = new ArrayList<>();
        keyTypes.add(new DataManagerKeyType(new Argument("NamespacedKey", "key") {{
            setDescription("Ключ");
        }}, false));
        keyTypes.add(new DataManagerKeyType(new Argument("String", "keyString") {{
            setDescription("Ключ");
        }}, true));
        for (DataManagerDataType dataType : dataTypes) {
            for (DataManagerKeyType keyType : keyTypes) {
                createDataTypeMethods(dataType, keyType);
            }
        }
    }

    public void createDataTypeMethods(DataManagerDataType dataType, DataManagerKeyType keyType) {
        addMethod(new Method("is" + dataType.getName()) {{
            setDocumentation(new MethodDocumentation() {{
                addLine("Проверка значения по ключу на тип " + dataType.getName() + ".");
                addLine("Если значения по ключу нет, будет возвращено false.");
            }});
            setReturn(new Return("boolean") {{
                setDescription("Является ли значение по ключу " + dataType.getName() + ".");
            }});
            addArgument(keyType.getArgument());
            setCode(new StatementBasedCode() {{
                if (keyType.isString()) addStatement("NamespacedKey key = new NamespacedKey(namespace, keyString)");
                addStatement("return container.has(key, PersistentDataType." + dataType.getType() + ")");
            }});
        }});

        addMethod(new Method("get" + dataType.getName()) {{
            setDocumentation(new MethodDocumentation() {{
                addLine("Получение " + dataType.getName() + " значения по ключу.");
                addLine("Если в контейнере нет указанного ключа, будет вызвано исключение.");
                addLine("Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.");
                addThrowDescription("DataManagerKeyError", "Если в контейнере нет указанного ключа, будет вызвано исключение.");
                addThrowDescription("DataManagerTypeError", "Если в контейнере значение по ключу неправильного типа, будет вызвано исключение.");
            }});
            setReturn(new Return(dataType.getPrimitive()) {{
                setDescription("Значение по ключу.");
            }});
            addArgument(keyType.getArgument());
            setCode(new StatementBasedCode() {{
                if (keyType.isString()) addStatement("NamespacedKey key = new NamespacedKey(namespace, keyString)");
                addSimpleIf("!container.has(key)", "throw new DataManagerKeyError(key)");
                addSimpleIf("!container.has(key, PersistentDataType." + dataType.getType() + ")", "throw new DataManagerTypeError(PersistentDataType." + dataType.getType() + ")");
                if (!dataType.isCustom()) {
                    addStatement("return container.get(key, PersistentDataType." + dataType.getType() + ")");
                } else if (dataType.getName().equals("Container")) {
                    addStatement("return new DataManager(container.get(key, PersistentDataType." + dataType.getType() + "))");
                }
            }});
        }});

        addMethod(new Method("get" + dataType.getName() + "OrNull") {{
            setDocumentation(new MethodDocumentation() {{
                addLine("Получение " + dataType.getName() + " значения по ключу.");
                addLine("Если в контейнере нет указанного ключа, будет возвращено null.");
                addLine("Если в контейнере значение по ключу неправильного типа, будет возвращено null.");
            }});
            setReturn(new Return(dataType.getKlass()) {{
                setDescription("Значение по ключу или null.");
                setAnnotation(new Annotation("@Nullable"));
            }});
            addArgument(keyType.getArgument());
            setCode(new StatementBasedCode() {{
                if (keyType.isString()) addStatement("NamespacedKey key = new NamespacedKey(namespace, keyString)");
                addSimpleIf("!container.has(key)", "return null");
                addSimpleIf("!container.has(key, PersistentDataType." + dataType.getType() + ")", "return null");
                if (!dataType.isCustom()) {
                    addStatement("return container.get(key, PersistentDataType." + dataType.getType() + ")");
                } else if (dataType.getName().equals("Container")) {
                    addStatement("return new DataManager(container.get(key, PersistentDataType." + dataType.getType() + "))");
                }
            }});
        }});

        addMethod(new Method("get" + dataType.getName() + "OrDefault") {{
            setDocumentation(new MethodDocumentation() {{
                addLine("Получение " + dataType.getName() + " значения по ключу.");
                addLine("Если в контейнере нет указанного ключа, будет возвращено значение по умолчанию.");
                addLine("Если в контейнере значение по ключу неправильного типа, будет возвращено значение по умолчанию.");
            }});
            setReturn(new Return(dataType.getKlass()) {{
                setDescription("Значение по ключу или значение по умолчанию.");
            }});
            addArgument(keyType.getArgument());
            addArgument(new Argument(dataType.getKlass(), "defaultValue") {{
                setDescription("Значение по умолчанию");
            }});
            setCode(new StatementBasedCode() {{
                if (keyType.isString()) addStatement("NamespacedKey key = new NamespacedKey(namespace, keyString)");
                addSimpleIf("!container.has(key)", "return defaultValue");
                addSimpleIf("!container.has(key, PersistentDataType." + dataType.getType() + ")", "return defaultValue");
                if (!dataType.isCustom()) {
                    addStatement("return container.get(key, PersistentDataType." + dataType.getType() + ")");
                } else if (dataType.getName().equals("Container")) {
                    addStatement("return new DataManager(container.get(key, PersistentDataType." + dataType.getType() + "))");
                }
            }});
        }});

        addMethod(new Method("set" + dataType.getName()) {{
            setDocumentation(new MethodDocumentation() {{
                addLine("Установка " + dataType.getName() + " значения по ключу.");
            }});
            setReturn(new Return("DataManager") {{
                setDescription("Этот же менеджер.");
            }});
            addArgument(keyType.getArgument());
            addArgument(new Argument(dataType.getPrimitive(), "value") {{
                setDescription("Значение");
            }});
            setCode(new StatementBasedCode() {{
                if (keyType.isString()) addStatement("NamespacedKey key = new NamespacedKey(namespace, keyString)");
                if (!dataType.isCustom()){
                    addStatement("container.set(key, PersistentDataType." + dataType.getType() + ", value)");
                } else if (dataType.getName().equals("Container")) {
                    addStatement("container.set(key, PersistentDataType." + dataType.getType() + ", value.container)");
                }
                addStatement("return this");
            }});
        }});
    }
}
